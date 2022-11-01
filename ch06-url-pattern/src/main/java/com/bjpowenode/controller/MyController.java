package com.bjpowenode.controller;

import com.bjpowenode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangzhilong
 * @dcreate 2021-10-20 16:10
 */
@Controller
@RequestMapping(value = "/user")
public class MyController {
    @RequestMapping(value = "/returnajax.do")
    @ResponseBody
    public Student returnStudentAjax(String name, Integer age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age){
        System.out.println("doSome name="+name+"  age="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("result");

        return mv;
    }
}
