var $modal;
function showDialog(modal,title,url){//blog/add
    $modal = $(modal);
	$modal.find('.modal-title').html(title);
	$modal.find('.modal-body').empty().load(url,function(){
		$modal.modal();
	});
}

/*function submitForm(){
	var $form=$modal.find('form');
	$.post(
		 	$form.attr('action'),
		 	$form.serialize(),
			function(data){
				if(data.result){
					swal({
						title: "操作成功!",
						type: "success",
						confirmButtonColor: "#DD6B55",
						confirmButtonText: "确定",
						closeOnConfirm: true
						
					},function(){
						console.log("对话框已经关闭");
						$modal.modal('hide');
						bootstrapTable.bootstrapTable("refresh");
					});
				}
			},
			'json'
		); 
	
}*/

function submitForm(){
	
	var $form = $modal.find('form');
	var action = $form.attr('action');
	//文件上传提交表单需要如下代码
	//FormData html5新添加的属性 ,可以支持文件上传
	//FormData 在ie8中不支持,  jquery.form.js
	//new FormData(dom)
	//jquery-->dom  $form.get(0);  $form[0]
	//dom-->jquery  $(dom)
	var form = new FormData($form.get(0));
	$.ajax({
		url:action,
		type:'post',
		data:form,
		async: false,
        cache: false,
        contentType: false,
        processData: false,
		success:function(data){
			data = JSON.parse(data);
			if(data.result){
				swal({
					title: "操作成功!",
					type: "success",
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "确定",
					closeOnConfirm: true
					
				},function(){
					console.log("对话框已经关闭");
					$modal.modal('hide');
					bootstrapTable.bootstrapTable("refresh");
				});
			}
			var a="";
			if(data.count!=null){
				a=data.count;
			}
			swal({
				title: "操作成功!",
				type: "success",
				text:""+a+"",
				confirmButtonColor: "#DD6B55",
				confirmButtonText: "确定",
				closeOnConfirm: true
			},function(){
				//console.log("对话框已经关闭");
				$modal.modal('hide');
				bootstrapTable.bootstrapTable('refresh');

			});
		}
	});
}

function del(url){
	//弹框提示是否确认删除
	swal({
		  title: "确认删除吗?",
		  text: "一旦删除数据不能恢复,请小心!",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#DD6B55",
		  confirmButtonText: "快删了吧,早看烦了!",
		  closeOnConfirm: false
		},
		function(isConfirm){
			  if (isConfirm) {
			    $.post(url,function(data){
			    	data = JSON.parse(data);
			    	if(data.result){
			    		swal("删除成功!", "满意否?", "success");
			    		bootstrapTable.bootstrapTable('refresh');
			    	}
			    	
			    });
			  }
			});
}

//批量删除
function batchDelete(url,idField ){
	
	var rows = bootstrapTable.bootstrapTable('getSelections');//获取当前选中的所有行
	
	if(rows.length == 0) return;//判断是否有行被选中
	
	var postData = {};//声明变量,存储请求删除对象的id数组
	
	$.each(rows, function(index){
		//this  表示当前行 rows[index]
		postData['id['+index+']'] = this[idField];
	});
	//弹框提示是否确认删除
	console.log(postData);
	swal({
		  title: "确认批量删除吗?",
		  text: "一旦删除数据不能恢复,请小心!",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#DD6B55",
		  confirmButtonText: "快删了吧,早看烦了!",
		  closeOnConfirm: false
		},
		function(isConfirm){
			  if (isConfirm) {
			    $.post(url,postData,function(data){
			    	/* data = JSON.parse(data); */
			    	if(data.result){
			    		swal("删除成功!", "满意否?", "success");
			    		bootstrapTable.bootstrapTable('refresh');
			    	}
			    	
			    },'json');
			  }
			});
}