# Spring Boot 时代的 Web MVC 自动装配

## 完全自动装配

完全自动装配指：不需要手动添加 Maven 插件，不需要实现接口 WebMvcConfigurer、AbstractAnnotationConfigDispatcherServletInitializer

* 自动装配 DispatcherServlet : DispatcherServletAutoConfiguration

* 替换 @EnableWebMvc : WebMvcAutoConfiguration

* Servlet 容器 ： ServletWebServerFactoryAutoConfiguration

## 命令

* 打包

  ```bash
  cd springboot-mvc
  mvn clean package -Dmaven.test.skip=true
  ```

* 运行jar

  ```bash
   java -jar target/springboot-mvc-0.0.1-SNAPSHOT.war
  ```

## IDEA 全路径搜索 `spring.mvc`

1. Find in Path
2. Scope: All Places
3. File mask：*.json

## 参考
* https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-spring-mvc