<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/18
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>显示处理返回的数据</h1>
    <h1>myname:${param.myname}</h1><br/>
    <h1>myage:${param.myage}</h1><br/>
    <h1>取参数数据:<%=request.getParameter("myname")%></h1><br/>
</body>
</html>
