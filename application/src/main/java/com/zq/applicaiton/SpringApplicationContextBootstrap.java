package com.zq.applicaiton;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 创建 SpringApplication#createApplicationContext
 *
 * 视频：3-14 创建 Spring 应用上下文.mp4
 *
 *
 * 创建 Spring 应用上下文（ ConfigurableApplicationContext ） SpringApplication#deduceWebApplicationType
 * 	根据准备阶段的推断 Web 应用类型创建对应的 ConfigurableApplicationContext 实例：
 * 		Web Reactive： 		AnnotationConfigReactiveWebServerApplicationContext
 * 		Web Servlet：   	AnnotationConfigServletWebServerApplicationContext
 * 		非 Web： 			AnnotationConfigApplicationContext
 *
 * 创建 Environment
 * 	根据准备阶段的推断 Web 应用类型创建对应的 ConfigurableEnvironment 实例：
 * 		Web Reactive： 		StandardEnvironment
 * 		Web Servlet： 		StandardServletEnvironment
 * 		非 Web： 			StandardEnvironment
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 15:10:41
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
		System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());

		// 关闭 Spring 应用上下文
		context.close();
	}
}
