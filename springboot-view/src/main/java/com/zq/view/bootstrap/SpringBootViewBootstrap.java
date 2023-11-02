package com.zq.view.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 视频：
 5-3 Thymeleaf 示例.mp4
 5-4 ThymeleafViewResolver和多ViewResolver处理流程.mp4
 5-5 ThymeleafViewResolver 示例.mp4
 5-6 整合InternalResourceViewResolver示例.mp4
 5-7 修复 Maven 多模块 JSP 定位问题 示例.mp4
 5-8 视图内容协商.mp4
 5-9 视图内容协商代码分析.mp4
 5-10 ViewResolver 冲突说明部分.mp4
 5-11 ViewResolver 内容协商原理.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-01 18:05:11
 */
@SpringBootApplication(scanBasePackages = "com.zq.view")
public class SpringBootViewBootstrap {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootViewBootstrap.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
	}
}
