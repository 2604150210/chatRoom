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
    <title>Register</title>
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
</style>
<div class="frame">
    <form action="/RegisterServlet">
        <table>
            <tr>
                <td>
                    用户名：
                </td>
                <td>
                    <input type="text" name="username" required>
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password" required>
                </td>
            </tr>
            <tr>
                <td>
                    重复密码：
                </td>
                <td>
                    <input type="password" name="password2" required>
                </td>
            </tr>
            <tr>
                <button class="btn btn-primary">注册</button>
            </tr>
        </table>


    </form>
</div>
<script>
    var errori = '<%=request.getParameter("error")%>';
    if (errori == 'errpsd'){
        alert("前后密码不一致，请重新提交注册！");
    }
</script>
</body>
</html>
