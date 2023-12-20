## 主要类
* FilterRegistrationBean

## 命令

### 部署  springboot-servlet

```bash
cd /Users/zhangquan/code/github.com/spring-boot-study/springboot-servlet
mvn clean package -Dmaven.test.skip=true
```

报如下错：

```bash
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.zq:springboot-servlet >----------------------
[INFO] Building springboot-servlet 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The POM for com.zq:spring-servlet:jar:0.0.1-SNAPSHOT is missing, no dependency information available
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.443 s
[INFO] Finished at: 2023-11-04T17:54:40+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal on project springboot-servlet: Could not resolve dependencies for project com.zq:springboot-servlet:jar:0.0.1-SNAPSHOT: Could not find artifact com.zq:spring-servlet:jar:0.0.1-SNAPSHOT -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException
```

解决：把  spring-servlet 当一个 jar 包部署到本地

```bash
# 安装到本地的 Maven 仓库中
cd /Users/zhangquan/code/github.com/spring-boot-study/spring-servlet
mvn clean install -Dmaven.test.skip=true
```

重新部署 springboot-servlet

```bash
cd /Users/zhangquan/code/github.com/spring-boot-study/springboot-servlet
mvn clean package -Dmaven.test.skip=true
```

报如下错误：

```bash
INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.zq:springboot-servlet >----------------------
[INFO] Building springboot-servlet 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.442 s
[INFO] Finished at: 2023-11-04T18:00:00+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal on project springboot-servlet: Could not resolve dependencies for project com.zq:springboot-servlet:jar:0.0.1-SNAPSHOT: Failed to collect dependencies at com.zq:spring-servlet:jar:0.0.1-SNAPSHOT: Failed to read artifact descriptor for com.zq:spring-servlet:jar:0.0.1-SNAPSHOT: Could not find artifact com.zq:spring-boot-study:pom:0.0.1-SNAPSHOT -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException
```

解决：把整个项目 install 到本地仓库中

```bash
cd /Users/zhangquan/code/github.com/spring-boot-study
mvn clean install -Dmaven.test.skip=true
```

如下报错:

```bash
[INFO]
[INFO] spring-boot-study .................................. SUCCESS [  0.301 s]
[INFO] overview ........................................... SUCCESS [  1.267 s]
[INFO] autoconfigure ...................................... SUCCESS [  0.792 s]
[INFO] application ........................................ SUCCESS [  0.156 s]
[INFO] spring-mvc ......................................... SUCCESS [  2.412 s]
[INFO] springboot-mvc ..................................... SUCCESS [  0.482 s]
[INFO] springboot-view .................................... SUCCESS [  0.558 s]
[INFO] springboot-rest .................................... SUCCESS [  0.182 s]
[INFO] spring-servlet ..................................... SUCCESS [  2.006 s]
[INFO] springboot-servlet ................................. FAILURE [  0.014 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.381 s
[INFO] Finished at: 2023-11-04T18:20:32+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal on project springboot-servlet: Could not resolve dependencies for project com.zq:springboot-servlet:jar:0.0.1-SNAPSHOT: Could not find artifact com.zq:spring-servlet:jar:0.0.1-SNAPSHOT -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException
[ERROR]
[ERROR] After correcting the problems, you can resume the build with the command
[ERROR]   mvn <args> -rf :springboot-servlet
```

解决：

springboot-servlet   pom.xml 里更改为 war 包

```xml
<packaging>war</packaging>
```

spring-servlet   pom.xml 里更改为 war 包

```xml
<packaging>war</packaging>
```

### 运行  springboot-servlet

```bash
cd /Users/zhangquan/code/github.com/spring-boot-study/springboot-servlet
java -jar target/springboot-servlet-0.0.1-SNAPSHOT-war-exec.jar
```

报如下错误：

```bash
信息: validateJarFile(/Users/zhangquan/code/github.com/spring-boot-study/springboot-servlet/.extract/webapps/ROOT/WEB-INF/lib/tomcat-embed-core-8.5.31.jar) - jar not loaded. See Servlet Spec 2.3, section 9.7.2. Offending class: javax/servlet/Servlet.class
十一月 04, 2023 6:39:43 下午 org.apache.catalina.loader.WebappClassLoader validateJarFile
信息: validateJarFile(/Users/zhangquan/code/github.com/spring-boot-study/springboot-servlet/.extract/webapps/ROOT/WEB-INF/lib/tomcat-embed-el-8.5.31.jar) - jar not loaded. See Servlet Spec 2.3, section 9.7.2. Offending class: javax/el/Expression.class
十一月 04, 2023 6:39:43 下午 org.apache.catalina.startup.ContextConfig getServletContainerInitializer
严重: The ServletContentInitializer [# Licensed to the Apache Software Foundation (ASF) under one or more] could not be created
java.lang.ClassNotFoundException: # Licensed to the Apache Software Foundation (ASF) under one or more
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1713)
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1558)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.apache.catalina.startup.ContextConfig.getServletContainerInitializer(ContextConfig.java:1659)
	at org.apache.catalina.startup.ContextConfig.processServletContainerInitializers(ContextConfig.java:1569)
	at org.apache.catalina.startup.ContextConfig.webConfig(ContextConfig.java:1277)
	at org.apache.catalina.startup.ContextConfig.configureStart(ContextConfig.java:878)
	at org.apache.catalina.startup.ContextConfig.lifecycleEvent(ContextConfig.java:369)
	at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:119)
	at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5179)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1559)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1549)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
```

修改  springboot-servlet pom.xml 排除以下依赖：

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```

再打包运行:

```bash
cd /Users/zhangquan/code/github.com/spring-boot-study/springboot-servlet
mvn clean package -Dmaven.test.skip=true
java -jar target/springboot-servlet-0.0.1-SNAPSHOT-war-exec.jar
```

修改  springboot-servlet pom.xml 排除以下依赖：

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.hibernate.validator</groupId>
                    <artifactId>hibernate-validator</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```



​				