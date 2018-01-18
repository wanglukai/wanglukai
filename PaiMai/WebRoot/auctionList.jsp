<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>在线拍卖系统 - 拍卖品列表</title>
    <%@ include file="/common/common_css.jsp" %>
    <style>
	.pageNo{
	color:red
	}
	
	</style>
</head>
<body>
<h1 style="text-align: center;">在线拍卖系统</h1>
<div id="toolbar" style="padding-left: 80px">
			<button class="btn btn-warning" onclick="showDialog('#myModal','批量添加博客','blog/batchAdd')"><i class="glyphicon glyphicon-plus"></i>批量导入</button>
			<button class="btn btn-danger" onclick="batchDelete('blog/batchdelete','id')"><i class="glyphicon glyphicon-remove"></i>批量删除</button>
			<button class="btn btn-primary" onclick="showDialog('#myModal','添加拍卖品','auctionAdd.jsp')"><i class="glyphicon glyphicon-plus"></i>添加</button>
		<form id="Condition" action="" method="post" style="margin-left:10px;display:inline-block" class="form form-inline ">
			<input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="title" placeholder="搜索标题"/>
			<input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" id="author" placeholder="搜索作者"/>
			<select class="form-control mb-2 mr-sm-2 mb-sm-0" id="leixingid">
				<option value="-1">全部</option>
				<c:forEach items="${categorys }" var="leixingid">
				<option value="${leixingid.id}">${leixingid.name}</option>
				</c:forEach>
			</select>
			<button type="button" class="btn btn-success" onclick="javascript:$('#tbl-blog').bootstrapTable('refresh')">搜索</button>
			<button type="reset" class="btn btn-primary">清空条件</button>
		</form>
			<button id="add" class="btn btn-primary" onclick="exportExcel('blog/daochu')"><i class="glyphicon glyphicon-plus"></i>批量导出</button>
			<a href="blog/dayin" target="_blank" class="btn btn-primary" id="add">打印</a> 
			 <!-- <a href="blog/fenlei">分类管理</a> -->
		</div>
		<table id="tbl-blog">
		
		</table>
		<div id="myModal" tabindex="-1" class="modal fade" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel"></h4>
		      </div>
		      <div class="modal-body">
		        ...
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button typfe="button" class="btn btn-primary" onclick="submitForm()">添加</button>
		      </div>
		    </div>
		</div>
		</div>
<div class="container">
    <table class="table table-hover table-bordered table-striped">
        <thead>
            <tr>
                <th>名称</th>
                <th>描述</th>
                <th>图片</th>
                <th>起拍价</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.alist }" var="auction">
                <tr>
                    <td>${auction.name}</td>
                    <td>${auction.esc}</td>
                    <td><img src="imgServlet?id=${auction.id}" width="50" height="50"/></td>
                    <td>${auction.startPrice}</td>
                    <td>${auction.startTime}</td>
                    <td>${auction.endTime}</td>
                    <td><a href="" style="color:red;text-decoration: none;">竞拍</a>
                    	<a href="javascript:void(0)" onclick="showDialog('#myModal','修改拍卖品','AuctionUpdateServlet?action=one&id=${auction.id}')" style="color:red;text-decoration: none;">修改</a>
                    	<a href="javascript:void(0);" onclick="deleteById('AuctionDeleteServlet?id=${auction.id}')" style="color:red;text-decoration: none;">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${user.isAdmin == 1}">
    	<div class="container">
    		<button class="btn btn-success" onclick="location.href='auctionAdd.jsp'">
    			<span class="glyphicon glyphicon-plus">添加拍卖商品</span>
    		</button>
    	</div>
    </c:if>
    <p style="text-align: center">
    	<a href="AuctionServlet?currentPage=1">首页</a>
    	<a href="AuctionServlet?currentPage=${sessionScope.pb.currentPage-1 }">上一页</a>
    	  <c:forEach begin="1" end ="${sessionScope.pb.totalPageCount }" var ="i">
		   <a href="AuctionServlet?currentPage=${i }" id="fang"
			  <c:if test="${sessionScope.pb.currentPage == i }">
			   class="pageNo"
			  </c:if>
		  >${i }</a> 
 		 </c:forEach>  	
    	<a href="AuctionServlet?currentPage=${sessionScope.pb.currentPage+1 }">下一页</a>
    	<a href="AuctionServlet?currentPage=${sessionScope.pb.totalPageCount }">末页</a>
    </p>
</div>
 <%@ include file="/common/common_js.jsp" %>
<script type="text/javascript">
var $modal;
function showDialog(modal,title,url){//blog/add
    $modal = $(modal);
	$modal.find('.modal-title').html(title);
	$modal.find('.modal-body').empty().load(url,function(){
		$modal.modal();
	});
}
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
			/* bo = JSON.parse(data); */
			if(data){
				swal({
					title: "操作成功!",
					type: "success",
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "确定",
					closeOnConfirm: true
					
				},function(){
					$modal.modal('hide');
					window.location.reload();
				});
			}

		}
	});

}

function deleteById(url){
	
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
			    	console.log(data)
			    	if(data){
			    		swal({
							title: "删除成功",
							type: "success",
							confirmButtonColor: "#DD6B55",
							confirmButtonText: "确定",
							closeOnConfirm: true
						},function(){
							//重新跳转页面
							//window.location.href="aaa.do?action=list&currentPage=1";
							window.location.reload();
						});
			    	}
			    	
			    });
			  }
			});
}	
</script>
</body>

</html>
