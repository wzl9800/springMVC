package com.bjpowenode.vo;

/**
 * @author wangzhilong
 * @dcreate 2021-10-19 16:46
 */
public class Student {
    //属性名和请求中参数名一样
    private String name;
    private Integer age;

    public Student() {
        System.out.println("无参构造方法执行!!!");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName"+name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
