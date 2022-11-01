<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/19
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<body>
    <p>使用java对象接收请求参数</p>
    <form action="root/receiveobject.par" method="post">
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
                <td align="center"><input type="submit" value="提交请求参数" /></td>
            </tr>

        </table>
    </form>
</body>
</html>
