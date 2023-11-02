### 找 Thymeleaf 的配置

1. 搜索 `ThymeleafProperties` 类，找到前缀 `spring.thymeleaf`

2. Find in Path 搜索 
   * scope 选择 All Places

### 浏览器访问

```ba
localhost:8080/hello-world
```

### 多视图处理器内容协商

http://localhost:8080

http://localhost:8080/?format=html

### 找 ThymeleafViewResolver、InternalResourceViewResolver 模板优化级

* 双击类名，Find Usages，然后找到优先级 Order

### 有JSP内容，在IDEA中运行，在浏览器上访问jsp内容失败

1. 可以命令行中打包，再运行，在

要注意 pom.xml 中要是 war 包

```
<packaging>war</packaging>
```

```bash
cd springboot-view
mvn clean package -Dmaven.test.skip=true
java -jar target/springboot-view-0.0.1-SNAPSHOT.war
```

2. 添加应添加到 Tomcat 上下文的 TomcatContextCustomizers。

   ```
   TomcatServletWebServerFactory
   TomcatServletWebServerFactoryCustomizer
   ```

### 视图组件自动装配

#### 自动装配

* Web MVC：`WebMvcAutoConfiguration`
* Thymeleaf Web MVC: `ThymeleafWebMvcConfiguration`
* Thymeleaf Web Flux:  `ThymeleafWebFluxConfiguration`

#### 外部化配置

* 内容协商：`WebMvcProperties.Contentnegotiation`
* Thymeleaf: `ThymeleafProperties`

### 备注

如果在 resources 下加了文件功能不生效，可以把 target 目录删除了，然后重新在 IDEA 中 Build

### 参考

* 内容协商
  * https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/spring-framework-reference/web.html#mvc-config-content-negotiation
  * https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-pathmatch