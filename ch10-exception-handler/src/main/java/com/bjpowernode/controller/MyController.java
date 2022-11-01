package com.bjpowernode.controller;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyUserException;
import com.bjpowernode.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wangzhilong
 * @dcreate 2021-10-18 20:01
 */
@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView exception(String name,Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();
        //根据请求参数抛出异常
        if(!"zs".equals(name)){
            throw new NameException("姓名不正确！！！");
        }
        if( age == null || age > 80){
            throw new AgeException("年龄不正确！！！");
        }

        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //显示转发（当你要转发的页面不在视图解析器指定的包里可以使用）
        mv.setViewName("result1");

        return mv;
    }
}
