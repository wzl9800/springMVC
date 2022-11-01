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
    <title>处理器方法的返回值</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                //alert("btn click");
                $.ajax({
                    //url:"returnVoid-ajax.wzl",
                    //url:"returnStudentJsonArray.wzl",
                    url:"returnStringData.wzl",
                    data:{
                        name:"刘翔同学",
                        age:23
                    },
                    type:"post",
                    //可加可不加
                    dataType:"text",
                    success:function(resp){
                        //resp从服务器端返回的是json格式的字符串{"name":"zhangsan","age":20}
                        //jquery会把字符串转为json对象，赋值给resp形参。
                        //alert("name="+resp.name+"     age="+resp.age);
                        /*$.each(resp,function(Element,object){
                            alert(object.name+"   "+object.age);
                        })*/
                        alert("返回的是文本数据:"+resp)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
        <form action="returnString-view.wzl" method="post">
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
    <p>处理器返回String表示视图完整路径</p>
    <form action="returnString-view2.wzl" method="post">
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
<button id="btn">发起ajax请求</button>
</body>
</html>
