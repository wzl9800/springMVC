<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/20
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js" ></script>
    <script type="text/javascript">
        $(function(){
            $("#but").click(function(){
                $.ajax({
                    url:"user/returnajax.do",
                    data:{
                        name:"李四",
                        age:23
                    },
                    type:"post",
                    dataType:"json",
                    success:function(resp){
                        alert("name"+resp.name+"age"+resp.age);
                    }
                })
            })
        })
    </script>
</head>
<body>
<p>使用ajax请求发送请求</p>
<button id="but">使用ajax发送请求</button>
<br/>
<p>处理器方法返回String表示视图名称</p>
<form action="user/some.do" method="post">
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
<img src="images/c.JPG" alt="我是一个静态资源,不能显示">
</body>
</html>
