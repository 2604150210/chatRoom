<%--
  Created by IntelliJ IDEA.
  User: jal
  Date: 2018/3/26 0026
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body onload="show()">
<script>
    window.setInterval("show();",10000);
    function show() {
        online();
        contents();
    }
    function online()
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("left").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","users.jsp",true);
        xmlhttp.send();
    }

    function contents()
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("right").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","contents.jsp",true);
        xmlhttp.send();
    }
</script>
<style>
    .test_box {
        width: 400px;
        min-height: 120px;
        max-height: 300px;
        _height: 120px;
        margin-left: auto;
        margin-right: auto;
        padding: 3px;
        outline: 0;
        border: 1px solid #a0b3d6;
        font-size: 12px;
        word-wrap: break-word;
        overflow-x: hidden;
        overflow-y: auto;
        _overflow-y: visible;
    }
</style>
<div id="wrap">
    <div id="top">
        <div id="left">

        </div>

        <div id="right">

        </div>
    </div>
    <div id="down">
        <form action="receiveServlet" method="get">
            <div>

               <textarea name="content" id="" cols="30" rows="10"></textarea>
                <input type="submit"value = "发表讲话">
            </div>
        </form>

    </div>
</div>
</body>
</html>
