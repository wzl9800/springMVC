<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/21
  Time: 21:40
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
    <title>Title</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<div align="center">
<p>添加学生的功能页面</p>
<form action="student/addStudent.do" method="get">
    <table border="2px">
        <tr>
            <th> 姓名:</th>
            <td><input type="text" name="name" /><br/></td>
        </tr>
        <tr>
            <th> 年龄:</th>
            <td><input type="text" name="age" /><br/></td>
        </tr>
        <tr>
            <th></th>
            <td align="center"><input type="submit" value="学生注册" /></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
