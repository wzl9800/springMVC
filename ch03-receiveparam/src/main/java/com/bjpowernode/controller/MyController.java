package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzhilong
 * @dcreate 2021-10-19 8:11
 */
@Controller
@RequestMapping(value = "/user")
public class MyController {

    /*
    *逐个接收请求参数：
    *   要求：处理器（控制器）方法的形参名和请求中参数名必须一致。
    *           同名的请求参数赋值给同名的形参
    *   框架接收请求参数
    *   1：使用request对象接收请求参数
    *       String strName = request.getParameter("name");
    *       String strAge = request.getParameter("age");
    *   2:springmvc框架通过DispatcherServlet调用MyController的controllerReceive（）方法
    *       调用方法，按名称对应，把接收的参数赋值给形参
    *       controllerReceive（strName，Integer.valueof(strAge)）
    *       框架会提供类型转换的功能，能把String转为int,long,float,double等类型。
    *
    *   400状态码是客户端错误，表示提交请求参数过程中，发生了问题。
    *   Integer可以提交空数据不会报错（只能赋值null，整数）
    *   int（只能是整数）
    *
    *   发现post请求是会出现中午乱码
    *   get请求不会
    * */
    @RequestMapping(value = "/receive.wzl")
    public ModelAndView controllerReceive(String name,Integer age){//和形参位置无关和名字有关
        //可以在方法中直接使用name，age
        ModelAndView mav = new ModelAndView();
        mav.addObject("myname",name);
        mav.addObject("myage",age);
        mav.setViewName("result1");
        return mav;
    }

    /*
    * 请求中参数和处理器方法的形参名不一样
    * @RequestParam：逐个接收请求参数中，解决请求中参数形参名不一致的问题
    *   属性：1，value  请求中参数名称
    *         2，required 是一个boolean，默认是true
    *           true：表示请求中必须包含此参数。
    *   位置：在处理器方法的形参定义的前面
    * */
    @RequestMapping(value = "/receiveparam.wzl")
    public ModelAndView controllerReceiveparam( @RequestParam(value = "pname",required = false) String name,
                                                @RequestParam("page") Integer age){//和形参位置无关和名字有关
        System.out.println("doSome,name="+name+"   age="+age);
        //可以在方法中直接使用name，age
        ModelAndView mav = new ModelAndView();
        mav.addObject("myname",name);
        mav.addObject("myage",age);
        mav.setViewName("result1");
        return mav;
    }
   /*
   //每个方法都要加，显得繁琐（解决办法放在过滤器中）
    public void doGet(HttpServletRequest request){
        //request.setCharacterEncoding("utf-8");
    }

    public void doPost(HttpServletRequest request){
        //request.setCharacterEncoding("utf-8");
    }
    */
}
