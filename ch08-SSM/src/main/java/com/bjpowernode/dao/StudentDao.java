package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangzhilong
 * @dcreate 2021-10-21 15:30
 */
public interface StudentDao {
    public int insertStudent(Student student);

    public List<Student> selectStudents();
}
