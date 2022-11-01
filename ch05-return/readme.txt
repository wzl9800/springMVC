ch05-return:处理器方法的返回值表示请求的处理结果。
1：ModelAndView：有数据和视图，对视图执行forword
2：String，表示视图，可以是逻辑名称，也可以是完整视图路径
3：void，不能表示数据，也不能表示视图
        在处理ajax的时候，可以使用void返回值。通过HttpServletResponse输出数据。响应ajax请求。
        ajax请求服务器端返回的就是数据，和视图无关。
4：Object：例如String，Integer ，Map ，List ，Student等等都是对象。
对象有属性，属性就是数据，所以返回object表示数据和视图无关。
可以使用对象表示数据，响应ajax请求。

现在做ajax请求，主要使用json的数据格式。实现步骤：
1：加入处理json的工具库依赖，springmvc默认使用jackson架包
2：在springmvc配置文件中加入<mvc:annotation-driven>注解驱动。
    功能等同于：json = om.writeValueAsString(student);
3：在处理器方法的上面加入@ResponseBoby注解
    功能等同于：
     response.setContentType("application/json;charset=utf-8");
     PrintWriter pw = response.getWriter();
     pw.println(json);

springmvc处理器方法返回object，可以转为json输出到浏览器，响应ajax的内部原理
1：<mvc:annotation-driven/>注解驱动。
注解驱动实现的功能是完成java对象到json，xml，text，二进制等数据格式的转换。
<mvc:annotation-driven/>在加入到springmvc配置文件后，会自动创建HttpMessageConverter接口
的7个实现类对象，包括MappingJackson2HttpMessageConverter（使用jackson工具库中的ObjectMapper实现java对象转为json字符串）
StringHttpMessageConverter（处理字符串的）处理器方法上面的@RequestMapping里面加属性：products=text/plain;charset=utf-8;解决乱码

HttpMessageConverter接口：消息转换器。
功能：定义了java转为json，xml等数据格式的方法。这个接口有很多的是实现类。
        这些实现类完成java对象到json，java对象到xml，java对象到二进制数据的转换
        项下面两个方法是控制类把结果输出给浏览器时使用的：
        boolean canWrite(Class<?> clazz, @Nullable MediaType mediaType);
        void write(T t, @Nullable MediaType contentType, HttpOutputMessage outputMessage)

        例如处理器方法
        @RequestMapping(value = "/teturnString.wzl")
        public Student doReturnView(HttpServletRequest request,String name,Integer age){
                Student student = new Student();
                student.setName("lisi");
                student.setAge(20);
                return student;
        }
        1）canWrite作为检查处理器方法的返回值，能不能转为contentType表示的数据格式。
            检查student（lisi，20）能不能转为contentType指定的数据格式。
            如果检查能转为json，canWrite方法返回true

        2）write：把处理器方法的返回值对象，调用jackson中的objectMapper转为json字符串。
        json = om.writeValueAsString(student);

2：@ResponseBoby注解
放在处理器方法的上面，通过HttpServletResponse输出数据，响应ajax请求的。
     response.setContentType("application/json;charset=utf-8");
     PrintWriter pw = response.getWriter();
     pw.println(json);

没有加注解驱动时标签时的状态
     [org.springframework.http.converter.ByteArrayHttpMessageConverter@45491d5b,
     org.springframework.http.converter.StringHttpMessageConverter@38dbc878,
     org.springframework.http.converter.xml.SourceHttpMessageConverter@110c2dbd,
     org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter@2e9bf5fb]
加了注解驱动时
    [org.springframework.http.converter.ByteArrayHttpMessageConverter@91148bb,
    org.springframework.http.converter.StringHttpMessageConverter@3033edce,
    org.springframework.http.converter.ResourceHttpMessageConverter@2b91d40,
    org.springframework.http.converter.ResourceRegionHttpMessageConverter@3cc6e4bd,
    org.springframework.http.converter.xml.SourceHttpMessageConverter@3f11370e,
    org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter@1063f0bf,
    org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter@5a7abcee,
    org.springframework.http.converter.json.MappingJackson2HttpMessageConverter@51125810]