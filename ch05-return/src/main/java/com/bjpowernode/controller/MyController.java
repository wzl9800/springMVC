package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhilong
 * @dcreate 2021-10-19 8:11
 */
@Controller
public class MyController {
    /*
    * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
    *
    *
    * */
    @RequestMapping(value = "/returnString-view.wzl")
    public String doReturnView(HttpServletRequest request,String name, Integer age){
        System.out.println("doReturnView,name="+name+"   age="+age);
        //可以自己手工添加数据到request作用域
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        //result1：逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forword转发操作
        return "result1";
    }

    //处理器方法返回String，表示完整视图路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnString-view2.wzl")
    public String doReturnView2(HttpServletRequest request,String name, Integer age){
        System.out.println("==doReturnView2==,name="+name+"   age="+age);
        //可以自己手工添加数据到request作用域
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        //完整视图路径，项目中不能配置视图解析器
        //框架对视图执行forword转发操作
        //  /WEB-INF/view//WEB-INF/view/result1.jsp.jsp
        return "/WEB-INF/view/result1.jsp";
    }

    //处理器方法返回void，响应ajax请求void
    @RequestMapping(value = "/returnVoid-ajax.wzl")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("??doReturnVoidAjax??,name="+name+"   age="+age);
        //处理ajax，使用json做数据格式
        //假设service调用完成，得到Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        //把结果的对象转为json格式的数据（使用jackson这个依赖）
        String json = "{}";
        if( student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json===="+json);
        }
        //输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /*
    * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
    *@ReaponseBoby：
    *   作用：把处理器方法返回对象转为json，通过HttpServletResponse输出给浏览器。
    *   位置：方法的定义上面。和其他注解没有位置关系。
    *
    *   返回对象框架的处理流程：
    *   1：框架会把返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法
    *       检查那个HttpMessageConverter接口的实现类能够处理Student类型的数据，MappingJackson2HttpMessageConverter
    *   2：框架会调用实现类的write（），MappingJaskson2HttpMessageConverter的Write()方法
    *       把李四同学的student对象转为json，调用jaskson中的objectMapper实现转为json
    *       contentType：application/json;charset=utf-8
    *   3：框架会调用@ResponseBoby把2的结果数据输出到浏览器，ajax请求处理完成
    * */
    @ResponseBody
    @RequestMapping(value = "/returnStudentJson.wzl")
    public Student doStudentJsonObject(Student mystudent){
        //调用service，获取请求结果数据，Student对象表示结果数据
        return mystudent;//会被框架转为json
    }

    /*处理器方法返回的是List集合*/
    @ResponseBody
    @RequestMapping(value = "/returnStudentJsonArray.wzl")
    public List<Student> doStudentJsonObjectArray(String name,Integer age){
        List<Student> list = new ArrayList<>();
        //调用service，获取请求结果数据，Student对象表示结果数据
        Student stu1 = new Student();
        stu1.setName("李四同学");
        stu1.setAge(28);
        list.add(stu1);

        stu1 = new Student();
        stu1.setName("张三同学");
        stu1.setAge(30);
        list.add(stu1);
        return list;//会被框架转为json
    }

    /*处理器方法返回的是String类型的数据（不是视图）
    * 区分返回值String是数据，还是视图，看有没有@ResponseBoby注解
    * 如果有@ResponseBoby注解，返回String数据，反之就是视图
    *
    * 默认使用"text/plain;charset=ISO-8859-1"作为contentType，导致中文有乱码，
    * 解决办法：给RequestMapping增加一个属性produces，使用这个属性指定新的contentType。
    *   返回String数据框架的处理流程：
     *   1：框架会把返回String类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *       检查那个HttpMessageConverter接口的实现类能够处理String类型的数据，StringHttpMessageConverter
     *   2：框架会调用实现类的write（），StringHttpMessageConverter的Write()方法
     *       把字符串按照指定的编码方式处理
     *       contentType：text/plain;charset=utf-8
     *
     *   3：框架会调用@ResponseBoby把2的结果数据输出到浏览器，ajax请求处理完成
    * */
    @RequestMapping(value = "/returnStringData.wzl",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }
}
