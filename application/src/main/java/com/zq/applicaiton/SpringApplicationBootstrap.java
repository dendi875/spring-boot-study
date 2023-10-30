package com.zq.applicaiton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * 视频：
 * 3-5 配置 Spring Boot Bean 源码部分.mp4
 * 3-6 推断 Web 应用类型.mp4
 * 3-7 推断引导类.mp4
 * 3-8 加载应用上下文初始器.mp4
 * 		1. IDEA Find Usages:  ApplicationContextInitializer
 * 		2. 实现示例 AfterApplicationContextInitializer、HelloWorldApplicationContextInitializer
 * 3-9 加载应用事件监听器.mp4
 * 		1. IDEA Find Usages:  ApplicationListener
 * 		2. 实现示例 	HelloWorldApplicationListener、AfterApplicationListener
 * 3-12 SpringApplication 运行监听器.mp4
 * 		1. IDEA Find Usages: SpringApplicationRunListener 定位到  spring-boot/META-INF/spring.factories
 * 		2. 实现示例 HelloWorldRunListener
 * 3-13 监听 Spring Boot 事件.mp4
 * 		1. IDEA Find Usages: ApplicationListener 定位到  spring-boot/META-INF/spring.factories
 * 		2. 实现示例 BeforeConfigFileApplicationListener
 *
 *
 * 配置 Spring Boot Bean 源
 * Java 配置 Class 或 XML 上下文配置文件集合，用于 Spring Boot BeanDefinitionLoader 读取 ，并且将配置源解析加载为Spring Bean 定义
 * 数量：一个或多个以上
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-29 21:22:32
 */

public class SpringApplicationBootstrap {

	// 1. 推断 Web 应用类型，SpringApplication#deduceWebApplicationType
	// 2. 推断 引导类 SpringApplication#deduceMainApplicationClass，Thread.currentThread().getStackTrace()
	public static void main(String[] args) {
		Set<String> sources = new HashSet<>();
		sources.add(ApplicationConfiguration.class.getName());

		SpringApplication application = new SpringApplication();
		application.setWebApplicationType(WebApplicationType.NONE);
		application.setSources(sources);
		application.run(args);
	}

	@SpringBootApplication
	public static class ApplicationConfiguration {

	}
}
