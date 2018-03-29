<%--
  Created by IntelliJ IDEA.
  User: jal
  Date: 2018/3/26 0026
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<script>
    var error = '<%=request.getParameter("error")%>';
    if(error == 'errgst'){
        alert("该账户已注册，请重新登录！");
        window.opener("login.jsp");
    }else if (error == 'errpsd'){
        alert("前后密码不一致，请重新提交注册！");
        window.opener("register.jsp");
    }
</script>
</body>
</html>
