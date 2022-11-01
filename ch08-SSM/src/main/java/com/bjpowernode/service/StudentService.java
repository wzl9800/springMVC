package com.bjpowernode.service;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;

import java.util.List;

/**
 * @author wangzhilong
 * @dcreate 2021-10-21 15:41
 */
public interface StudentService {

     int addStudent(Student student);

     List<Student> findStudent();
}
