<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/18
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交参数给controller接收</title>
</head>
<body>
    <p>提交参数给controller</p>
        <form action="user/receive.wzl" method="post">
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

        <br/>
        <p>请求中参数和处理器方法的形参名不一样</p>
    <form action="user/receiveparam.wzl" method="post">
        <table border="2px">
            <tr>
                <th> 姓名:</th>
                <td><input type="text" name="pname" /><br/></td>
            </tr>
            <tr>
                <th> 年龄:</th>
                <td><input type="text" name="page" /><br/></td>
            </tr>
            <tr>
                <th></th>
                <td align="center"><input type="submit" value="提交请求参数" /></td>
            </tr>

        </table>
    </form>
</body>
</html>
