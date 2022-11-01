<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/21
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>">
</head>
<body>
<div align="center">
    <p>SSM整合的例子</p>
    <img src="images/d.JPG"/>
    <table>
    <tr>
        <td><a href="addStudent.jsp">添加学生</a></td>
    </tr>
    <tr>
        <td><a href="listStudent.jsp">浏览学生</a></td>
    </tr>
    </table>
</div>
</body>
</html>
