package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzhilong
 * @dcreate 2021-10-19 16:28
 */
@Controller
@RequestMapping(value = "/root")
public class MyController {
    /*
    * 处理器方法形参是java对象，这个对象的属性名和请求中参数名一样的
    * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
    *
    * */
    @RequestMapping(value = "/receiveobject.par")
    public ModelAndView objectparam(Student mystudent){
        System.out.println("objectparam,name="+mystudent.getName()+"   age="+mystudent.getAge());
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",mystudent.getName());
        mv.addObject("myage",mystudent.getAge());
        mv.addObject("mystudent",mystudent);
        mv.setViewName("parandobj");
        return mv;
    }
}
