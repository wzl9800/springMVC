package com.bjpowernode.controller;

import com.bjpowernode.entity.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzhilong
 * @dcreate 2021-10-21 15:50
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService service;
    //注册学生
    @RequestMapping(value = "/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String message = "注册失败";
        //调用service处理student
        int nums = service.addStudent(student);
        if(nums > 0){
            message = "学生["+student.getName()+"]注册成功";
        }
        mv.addObject("message",message);
        mv.setViewName("result");
        return mv;
    }

    //处理查询，响应ajax
    @ResponseBody
    @RequestMapping(value = "/queryStudent.do")
    public List<Student> queryStudent() {
        //参数检查，简单的数据处理
        List<Student> studentList = service.findStudent();
        return studentList;
    }
}
