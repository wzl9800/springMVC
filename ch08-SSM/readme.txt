ch08-SSM:SSM整合开发。
SSM：SpringMVC+Spring+Mybatis

SpringMVC：视图层（界面层），负责接收请求，显示处理结果的。
Spring：业务层，管理service，dao，工具类对象的。
Mybatis：持久层，访问数据库的

用户发起请求---SpringMVC接收---Spring中的service对象---Mybatis处理数据

SSM整合也叫SSI（IBatis也就是mybatis的前身），整合中有容器。
1：第一个容器SpringMVC容器，管理Controller控制器对象的。
2：第二个容器Spring容器，管理service，dao，工具类对象的
我们要做的是：把使用的对象交给合适的容器创建，管理。把Controller还有web开发的相关对象
交给springmvc容器，这些web对象写在springmvc配置文件中

service，dao，对象定义在spring的配置文件中，让spring管理这些对象。

springmvc容器和spring容器是有关系的，关系已经确定好了
springmvc容器是spring容器的子容器，类似java中的继承。子可以访问父的内容
在子容器中的Controller可以访问父容器中的service对象，就可以实现Controller使用service对象

实现步骤：
1：使用test的mysql库，表使用student（id auto_increment,name,age）
2：新建maven web项目
3：加入依赖
    springmvc，spring，mybatis三个框架的依赖，jackson依赖，mysql驱动，druid连接池
    spring和mybatis整合需要的依赖，事务方面的依赖，jsp，servlet依赖
4：写web.xml文件
    1）注册DispatcherServlet（中央调度器）目的：1，创建springmvc容器对象，才能创建Controller类对象。
                                               2，创建的是Servlet，才能接收用户请求。

    2）注册spring监听器：ContextLoaderListener，目的：创建spring的容器对象，才能创建service，dao对象。

    3）注册字符集过滤器，解决post请求乱码的问题（filter）

5：创建包，Controller包，service，dao，实体类包名创建好

6：写springmvc，spring，mybatis的配置文件
    1）springmvc配置文件
    2）spring配置文件
    3）mybatis配置文件
    4）数据库的属性配置文件

7：写代码，dao接口和mapper文件，service和实现类，Controller实现类。

8：写jsp页面