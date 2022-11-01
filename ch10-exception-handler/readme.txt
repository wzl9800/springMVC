ch10-exception-handler:异常处理

异常处理步骤：
1：新建maven web项目
2：加入依赖
3：新建一个自定义异常类MyUserException，再定义它的子类NameException，AgeException
4：在Controller类中抛出NameException，AgeException
5：创建一个普通类，作用：全局异常处理类
    1）在类的上面加入@ControllerAdvice
    2）在类中定义方法，方法的上面加入@ExceptionHandler
6：创建异常处理异常的视图页面
7：创建springmvc配置文件
    1）组件扫描器，扫描@Controller注解
    2）组件扫描器，扫描@ControllerAdvice所在的包名
    3）声明注解驱动