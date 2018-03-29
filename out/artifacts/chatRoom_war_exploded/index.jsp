<%--
  Created by IntelliJ IDEA.
  User: jal
  Date: 2018/3/25 0025
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Index</title>
  <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<style>
    .frame{
        width:300px;
        height: 200px;
        position: absolute;
        left:50%;
        right: 50%;
        top:50%;
        margin:-100px 0 0 -150px;
        background-image: image("/img/img1.jpg");
    }
</style>
<script>
    function login() {
        window.open("login.jsp");
    }
    function register() {
        window.open("register.jsp");
    }

</script>
<div class="frame">
    <button class="btn btn-success" onclick="login()">登录</button>
    <button class="btn btn-primary" onclick="register()">注册</button>
</div>
<script>
    var errori = '<%=request.getParameter("error")%>';
    if(errori == 'yes'){
        alert("账号不存在，请先注册或者重新登录！");
    }
</script>
</body>
</html>
