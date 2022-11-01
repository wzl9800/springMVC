package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzhilong
 * @dcreate 2021-10-18 20:01
 */
@Controller
@RequestMapping(value = "/user")
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView exception(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //显示转发（当你要转发的页面不在视图解析器指定的包里可以使用）
        mv.setViewName("result1");

        return mv;
    }
}
