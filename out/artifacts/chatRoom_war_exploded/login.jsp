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
    }
    button{
        margin:0 auto;

    }
</style>
<div class="frame">
    <form action="/LoginServlet">
       <p>用户名：&nbsp;<input type="text" name="username"></p>
        <p>密&nbsp;&nbsp;&nbsp;&nbsp;码：&nbsp;<input type="password" name="password"><br></p>
        <button class="btn btn-success">登录</button>
    </form>
</div>
<script>
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'yes'){
        alert("密码错误，登录失败！");
    }else if(errori == 'errgst'){
        alert("该账户已注册，请重新登录！");
    }
</script>
</body>
</html>
