package com.bjpowernode.service.Impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzhilong
 * @dcreate 2021-10-21 15:44
 */
@Service
public class StudentServiceImpl implements StudentService {
    //引用类型的自动注入@Autowired，@Resource
    @Autowired
    private StudentDao studentDao = null;
    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudent() {
        List<Student> studentList = studentDao.selectStudents();
        return studentList;
    }
}
