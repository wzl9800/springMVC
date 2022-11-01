package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangzhilong
 * @dcreate 2021-10-25 9:33
 */
public class MyInterceptor implements HandlerInterceptor {
    /*
    * preHandle叫做预处理方法。
    * 参数
    *   Object handler：被拦截的控制器对象（MyController）
    * 返回值boolean
    *   true
    *   false
    * 特点：
    *   1：方法在控制器方法（MyController的doSome）之前先执行的。
    *       用户的请求首先到达此方法
    *
    *   2：在这个方法中获取请求的相关信息，验证请求是否符合要求。
    *       可以验证用户是否登录，验证用户是否有权限访问某个地址（url）。
    *       如果验证失败，可以截断请求，请求不能被处理
    *       如果验证成功，可以放行请求，此时控制器方法才能执行。
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器的MyInterceptor的preHandle方法执行");
        return true;
    }

    /*
    *   postHandle：后处理方法。
    *   参数：
    *       Object handler：被拦截的处理器对象
    *       ModelAndView mv :处理器方法的返回值
    *
    *       特点：
    *       1：在处理器方法之后执行的
    *       2：能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的
    *       数据和视图，可以影响到最后的执行结果。
    *       3：主要是对原来的执行结果做二次修正。
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器的MyInterceptor的postHandle方法执行");
    }

    /*
    *   afterCompletion：最后执行的方法
    *   参数
    *       object handler：被拦截的处理器对象
    *       Exception ex：程序中发生的异常
    *   特点：
    *   1：在请求处理完成后执行。框架中规定当你的视图处理完成后，对视图执行了forward。就认为请求处理完成。
    *   2：一般做资源回收工作的，程序请求中创建了一些对象，在这里可以删除，把占用的内存回收。
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器的MyInterceptor的afterCompletion方法执行");
    }
}
