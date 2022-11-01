package com.bjpowernode.exception;

/**
 * @author wangzhilong
 * @dcreate 2021-10-22 10:42
 */
//表示当用户的年龄有异常时，抛出AgeException
public class AgeException extends MyUserException {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
