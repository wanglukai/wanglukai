<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>在线拍卖系统 - 用户登录</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container bg-success" style="margin: 30px auto;">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form method="post" action="UserServlet">
                <div class="form-group">
                    <label for="username">用户名:</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">登录密码:</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="请输入登录密码">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">登录</button>
                    <button type="reset" class="btn btn-default">取消</button>
                </div>
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
