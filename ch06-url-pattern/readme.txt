tomcat本身能处理静态资源的访问，象html，图片，js文件都是静态资源

tomcat的web.xml文件有一个servlet名称是default，在服务器启动时创建的。
<servlet>
        <servlet-name>default</servlet-name>
        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
        <init-param>
            <param-name>debug</param-name>
            <param-value>0</param-value>
        </init-param>
        <init-param>
            <param-name>listings</param-name>
            <param-value>false</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
            <servlet-name>default</servlet-name>
            <url-pattern>/</url-pattern>表示静态资源和未映射的请求都用这个default处理
        </servlet-mapping>
default这个servlet作用：
The default servlet for all web applications, that serves static
resources.  It processes all requests that are not mapped to other
servlets with servlet mappings (defined either here or in your own
web.xml file).

1:处理静态资源
2：处理未映射到其他servlet的请求

<!--使用斜杠“/”
        当你的项目中使用了 /，它会替代tomcat中的default
        导致所有的静态资源给DispatcherServlet处理，默认情况下DispatcherServlet没有处理静态资源的能力。
        没有控制器对象能处理静态资源的访问。所以静态资源（html，js,图片，css）都是404

        动态资源some.do是可以访问的，因为我们程序中有MyController控制器对象，能处理some.do请求
-->
第一种处理静态资源的方式：(依赖于服务器)
    需要在springmvc配置文件中加入<mvc:default-servlet-handler>
    原理是：加入这个标签后，框架会创建控制器对象DefaultServletHttpRequestHandler（类似我们自己创建的MyController）
    DefaultServletHttpRequestHandler这个对象可以把接收的请求转发给tomcat的default这个servlet。
     <!--default-servlet-handler和@RequestMapping注解有冲突，需要加入annotation-driven解决问题-->
     <mvc:annotation-driven/>

第二种处理静态资源的方式：（不依赖与tomcat服务器）
    <mvc:resources mapping="" location="" />
    加入框架会创建ResourceHttpRequestHandler这个处理器对象。
    让这个对象处理静态资源的访问，不依赖tomcat服务器。
    mapping：访问静态资源的uri地址，使用通配符**
    location：静态资源在你的项目中的目录位置。