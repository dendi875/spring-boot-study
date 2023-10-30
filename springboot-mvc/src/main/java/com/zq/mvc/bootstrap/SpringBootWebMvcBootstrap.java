package com.zq.mvc.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 视频：
 * 4-13 Spring Boot 时代的简化.mp4
 * 4-14 完全自动装配.mp4
 * 4-15 条件装配.mp4
 * 4-16 外部化配置.mp4
 * 4-17 简Spring Boot 时代的简化 - 课纲部分.mp4
 * 4-18 重构 Spring Web MVC 项目.mp4
 *
 * 完全自动装配
 * 自动装配 DispatcherServlet : DispatcherServletAutoConfiguration
 * 替换 @EnableWebMvc : WebMvcAutoConfiguration
 * Servlet 容器 ： ServletWebServerFactoryAutoConfiguration
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 20:50:11
 */
@SpringBootApplication(scanBasePackages = "com.zq.mvc")
public class SpringBootWebMvcBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcBootstrap.class, args);
	}
}
