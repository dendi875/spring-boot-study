## 命令

* 打包

  ```bash
  cd /path/to/spring-servlet
  
  mvn clean package -Dmaven.test.skip=true
  ```

* 运行jar

  ```bash
   java -jar target/spring-servlet-0.0.1-SNAPSHOT-war-exec.jar
  ```

* 带 Debug 运行

  ```bash
  java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/spring-servlet-0.0.1-SNAPSHOT-war-exec.jar
  ```

## 浏览器访问
http://localhost:8080/hello-world

http://localhost:8080/callable-hello-world

http://localhost:8080/completion-stage

http://localhost:8080/async-servlet

## Spring Web MVC 异步 Servlet 实现原理

#### HandlerMethodReturnValueHandler

* DeferredResultMethodReturnValueHandler

#### Servlet 3.0 AsyncContext、AsyncListener

#### DispatcherServlet 整合

## 参考资料

* https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/spring-framework-reference/web.html#mvc-ann-async
