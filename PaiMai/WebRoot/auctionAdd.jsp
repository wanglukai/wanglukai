<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'auctionAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form  class="form-horizontal" action="AuctionAddServlet" method="post" enctype="multipart/form-data">
    	<div class="form-group">
    		<lable for="name" class="col-sm-2 control-label">名称：</lable>
    		<div class="col-sm-10">
    			<input type="text" name="name" class="form-control" id="title" placeholder="名称">
    		</div>
    	</div>
    	<div class="form-group">
		    <label for="pic" class="col-sm-2 control-label">描述 :</label>
		    <div class="col-sm-10">
		      <input type="text" name="esc" class="form-control" id="pic" placeholder="描述">
		    </div>
  		</div>
  		 <div class="form-group">
  			<label class="col-sm-2 control-label">图片：</label>
  			<div class="col-sm-10">
		      <input type="file" name="pic" class="form-control" id="pic" placeholder="上传图片">
		    </div>
  		</div>
  		<div class="form-group">
  			<label for="issueDate" class="col-sm-2 control-label">起拍价：</label>
  			<div class="col-sm-10">
  				<input type="text" name="startPrice" class="form-control" id="issueDate" placeholder="起拍价">
  			</div>
  		</div> 
    	<div class="form-group">
		    <label for="content" class="col-sm-2 control-label">开始时间：</label>
		    <div class="col-sm-10">
		      <input type="text" name="startTime" class="form-control date-picker" id="content" placeholder="开始时间">
		      <script type="text/javascript">
  					$(".date-picker").datepicker({
  						language:"zh-CN",
  						autoclose:true,
  						format:"yyyy/mm/dd"
  					});
  				</script>
		    </div>
  		</div>
  		<div class="form-group">
		    <label for="author" class="col-sm-2 control-label">结束时间：</label>
		    <div class="col-sm-10">
		      <input type="text" name="endTime" class="form-control date-picker" id="author" placeholder="结束时间">
		     <script type="text/javascript">
  					$(".date-picker").datepicker({
  						language:"zh-CN",
  						autoclose:true,
  						format:"yyyy/mm/dd"
  					});
  				</script>
		    </div>
  		</div>
  		
  		
    </form>
  </body>
</html>
