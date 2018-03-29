<%@ page import="chatroom.dao.DB" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: jal
  Date: 2018/3/27 0027
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contents</title>
</head>
<body>
<div>
    <h3>611聊天室~</h3>
    <ul>
        <%
            DB con = new DB();
            con.createCon();
            String sql = String.format("SELECT * FROM contents");
            // System.out.println("sql1:"+sql);
            ResultSet resultSet = con.executeQuery(sql);
            while (resultSet.next()){
        %>
                <li>
                    <span><%=resultSet.getString(3)%></span><br>
                    <span><%=resultSet.getString(1)%></span>说：
                    <span><%=resultSet.getString(2)%></span>

                </li>
        <%
            }
        %>
    </ul>
</div>
</body>
</html>
