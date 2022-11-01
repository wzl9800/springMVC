package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzhilong
 * @dcreate 2021-10-18 20:01
 */

/*
* @RequestMapping:
*    value:所有请求地址公共部分，叫做"模块名称"
*    位置：放在类的上面
* */
@Controller
public class MyController {

    /*
    *   处理器方法返回@ModelAndView，实现转发forward
    *   语法：setViewName("forward:视图文件完整路径")
    *   forward特点：不和视图解析器一同使用，就当项目中没有视图解析器
    * */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView forward(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("key1","====?处理doForward.do?请求（forward）===");
        mv.addObject("key2","===?执行controllersome?的方法处理请求===");

        //显示转发（当你要转发的页面不在视图解析器指定的包里可以使用）
        mv.setViewName("forward:/show.jsp");

        return mv;
    }

    /*
    * 处理器方法返回ModelAndView，实现重定向redirect
    * 语法：setViewName("redirect:视图完整路径");
    * redirect特点：不和视图解析器一同使用，就当项目中没有视图解析器
    *
    * 1，框架会把Model中的简单类型的数据，转为string使用，作为hello.jsp请求参数使用。
    *   目的是在doRedirect.do和hello.jsp两次请求之间传递数据
    *
    * 2，在目标hello.jsp页面可以使用参数集合对象${param}获取请求参数值
    *       ${param.myname}
    *
    * 3,重定向不能访问/WEB-INF资源
    * */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView redirect(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        //数据是放入到request作用域
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        //重定向
        //mv.setViewName("redirect:/show1.jsp");
        //http://localhost:8080/ch09-forward-redirect/hello.jsp?myname=lisi&myage=23;
        mv.setViewName("redirect:/WEB-INF/view/show1.jsp");
        return mv;
    }
}
