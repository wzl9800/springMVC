 <%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href= "<%=basePath%>">
</head>
<body>
    <p>第一个springmvc</p>
    <p><a href="user/some.do">发起user/some.do的get请求</a> </p>
    <br/>
</body>
</html>
