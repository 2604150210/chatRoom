<%@ page import="java.util.ArrayList" %>
<%@ page import="chatroom.model.User" %><%--
  Created by IntelliJ IDEA.
  User: jal
  Date: 2018/3/27 0027
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<style>
    .wrap{
        background-color: aqua;
    }
</style>
<div class="wrap">
    <h3>在线用户列表：</h3>
    <ul class="list">

    <%
        ArrayList<User> users = (ArrayList<User>) application.getAttribute("users");
        for(int i = 0; i < users.size(); i++){
            User everyUser = users.get(i);
    %>
            <li>
                <%=everyUser.getName()%>
            </li>
    <%
        }
    %>
    </ul>
</div>
</body>
</html>
