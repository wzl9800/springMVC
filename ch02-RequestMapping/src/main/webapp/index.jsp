<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc</p>
    <p><a href="user/first.do">发起some.do的get请求</a> </p>
    <form action="user/first.do" method="post">
        <input type="submit" value="post请求other.do">
    </form>

    <%--<p><a href="user/other.do">发起other.do请求不指定任何方式</a> </p>--%>
</body>
</html>
