# Spring Framework 时代的 Web MVC 自动装配

## 主要类

### DispatcherServlet

* ```java
  doDispatch(HttpServletRequest request, HttpServletResponse response)
  ```

### WebMvcConfigurer

### SpringServletContainerInitializer

### WebApplicationInitializer

### RequestContextHolder

### ServletRequestAttributes

```java
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
```



## 主要注解

### @EnableWebMvc

```java
@Import(DelegatingWebMvcConfiguration.class)
DelegatingWebMvcConfiguration 及它的父类 WebMvcConfigurationSupport
```

## 借助IDEA调试Spring-webmvc程序

1. IDEA Edit Configurations...

2. 点击+号，添加 Remote

3. 进行配置

   * 给个名字，比如 Spring MVC Debug

   * 复制 JVM 参数 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005

4. Shell 中在进行 java -jar xxxx.jar 启动时，添加 JVM 参数，比如

   ```bash
   java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/xxxx-war.jar
   ```

5. attach 到我们工程里
   * 点击 IDEA 右上角的 Debug 按钮

6. 浏览器中访问我们的url，比如 localhost:8080
7. 在 IDEA 中的 Debug 就有信息了，就可以 Debug 了

## **常用注解**

https://docs.spring.io/spring-framework/docs/5.2.25.RELEASE/spring-framework-reference/web.html#mvc-controller

注册模型属性： @ModelAttribute

读取请求头： @RequestHeader

读取 Cookie： @CookieValue

校验参数： @Valid 、 @Validated

异常处理： @ExceptionHandler

切面通知： @ControllerAdvice

## 命令

* 打包

  ```bash
  mvn clean package -Dmaven.test.skip=true
  ```

* 运行jar

  ```bash
  java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/spring-mvc-0.0.1-SNAPSHOT-war-exec.jar
  ```