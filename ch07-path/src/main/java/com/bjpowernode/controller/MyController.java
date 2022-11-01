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
public class MyController {

    @RequestMapping(value = "/user/some.do")
    public ModelAndView controllersome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("key1","====?处理some.do?请求（get）===");
        mv.addObject("key2","===?执行controllersome?的方法处理请求===");

        mv.setViewName("/index.jsp");

        return mv;
    }
}
