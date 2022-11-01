package com.bjpowernode.exception;

/**
 * @author wangzhilong
 * @dcreate 2021-10-22 10:40
 */
//表示当用户的姓名有异常，抛出NameException
public class NameException extends MyUserException {
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
