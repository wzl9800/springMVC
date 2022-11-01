SpringMVC：是基于spring的一个框架，实际上就是spring的一个模块，专门做web开发的。
	      理解是servlet的一个升级

	web开发底层是servlet，框架是在servlet基础上加入了一些功能，让你做web开发方便。

SpringMVC就是一个Spring。Spring是容器，ioc能够管理对象，使用<bean>创建对象给属性赋值,
	注解：@Component @Repository @Service @Controller
SpringMVC能够创建对象，放入到容器中（SpringMVC容器），springmvc容器中放的是控制器对象，

我们要做的是使用@Controller创建控制器，把对象放入到springMVC容器中，把创建的对象作为控制器使用
这个控制器对下对象接收用户的请求，显示处理结果，就当做是一个servlet使用。

使用@Controller注解创建的是一个普通类的对象，不是servlet。springmvc赋予了控制器对象一些额外的功能。

index.jsp发送请求给tomcat里面的servlet，servlet再调用service或这dao层

web开发底层是servlet，springmvc中有一个对象是servlet：DispatherServlet（中央调度器）
DispatherServlet：负责接收用户的所有请求，用户把请求给了DispatherServlet，之后DispatherServlet
		把请求转发给，我们的Controller对象，最后是Controller对象处理请求。

	发送请求
index.jsp------------DispatherServlet（Servlet）----转发，分配给-----Controller对象（@Controller注解创建的对象）