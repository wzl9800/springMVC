<%--
  Created by IntelliJ IDEA.
  User: 王志龙
  Date: 2021/10/21
  Time: 22:29
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
    <title>查看学生数据</title>
    <base href="<%=basePath%>" />
    <script type="text/javascript" src="js/jquery-3.4.1.js" ></script>
    <script type="text/javascript">
        $(function(){
            //在当前页面dom对象加载后，执行loadStudentData（）
            loadStudentData();

            $("#btnLoder").click(function(){
                loadStudentData();
            })
        })

        function loadStudentData(){
            $.ajax({
                url:"student/queryStudent.do",
                dataType:"json",
                type:"get",
                success:function (resp) {
                    //alert(resp);
                    //清除旧的数据
                    $("#info").html("");
                    $.each(resp,function(i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table border="2px">
        <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
        </thead>
        <tbody id="info">

        </tbody>
    </table>
    <input type="button" id="btnLoder" value="查询数据"/>
</div>
</body>
</html>
