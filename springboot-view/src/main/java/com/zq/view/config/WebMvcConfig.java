package com.zq.view.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver myViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		// ThymeleafViewResolver Ordered.LOWEST_PRECEDENCE - 5
		viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);

		// 配置 ViewResolver 的 Content-Type
		viewResolver.setContentType("text/xml;charset=UTF-8");

		return viewResolver;
	}

	// 内容协商
	// 视频：
	// 5-8 视图内容协商.mp4
	// 5-9 视图内容协商代码分析.mp4
	// 5-10 ViewResolver 冲突说明部分.mp4
	// 5-11 ViewResolver 内容协商原理.mp4
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.favorParameter(true)
				.favorPathExtension(true);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				System.out.println("拦截中...");
				return true;
			}
		});
	}

	// 视频：5-7 修复 Maven 多模块 JSP 定位问题 示例【更多IT教程 微信352852792】[2].mp4
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
		return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
			@Override
			public void customize(TomcatServletWebServerFactory factory) {
				factory.addContextCustomizers((context) -> {
							String relativePath = "springboot-view/src/main/webapp";
							// 相对于 user.dir =/Users/zhangquan/code/github.com/spring-boot-study
							File docBaseFile = new File(relativePath);
							if (docBaseFile.exists()) { // 路径是否存在
								// 解决 Maven 多模块 JSP 无法读取的问题
								context.setDocBase(docBaseFile.getAbsolutePath());
							}
						}
				);
			}
		};
	}
}
