package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@RequestMapping(value = "/user")
public class MyController {
    /*
    * 指定some.do使用get请求方式
    * @RequeatMpping：请求映射
    *   属性：method，表示请求的方式。它的值RequestMethed类枚举值。
    *   例如表示get请求方式，RequestMethod.GET
    *   post方式：RequeatMethod.POST
    * */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView controllersome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("key1","====?处理some.do?请求（get）===");
        mv.addObject("key2","===?执行controllersome?的方法处理请求===");

        mv.setViewName("result1");

        return mv;
    }
    //使用post方式发送请求
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView controllerother(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("key1","发送一个user/other.do请求（post）");
        mv.addObject("key2","处理user/other.do请求后的结果");

        mv.setViewName("result2");
        return mv;
    }

    //不指定任何方式
    @RequestMapping(value = "/first.do")
    public ModelAndView controller(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("key1","发送一个user/other.do请求（没有任何方式）"+"name="+request.getParameter("name"));
        mv.addObject("key2","处理user/other.do请求后的结果");

        mv.setViewName("result2");
        return mv;
    }
}
