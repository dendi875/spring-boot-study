package com.zq.boot.servlet;

import com.zq.servlet.AsyncServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * 视频：7-15 Spring Boot 嵌入式 Servlet 容器限制.mp4
 *
 * Spring Boot Servlet 注册的三种方式：
 * 第一种：@Bean 方式：RegistrationBean、Servlet 组件
 * 第二种：注解方式： @ServletComponentScan
 * 第三种：接口编程方式：ServletContextInitializer
 *
 * 不管是第一种还是第二种最终都是通过接口编程方式： ServletContextInitializer 的实现。
 *
 * http://localhost:8081/async-servlet
 * http://localhost:8081/
 *
 * 参考资料：
 * https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#howto-convert-an-existing-application-to-spring-boot
 * https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-embedded-container
 *
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-04 12:07:55
 */
@EnableAutoConfiguration
@ServletComponentScan(basePackages = "com.zq.servlet")
public class SpringBootServletBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServletBootstrap.class, args);
	}

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ServletRegistrationBean asyncServletServletRegistrationBean(){
		ServletRegistrationBean registrationBean =  new ServletRegistrationBean(new AsyncServlet(),"/");
		registrationBean.setName("MyAsyncServlet");
		return registrationBean;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			CharacterEncodingFilter filter = new CharacterEncodingFilter();
			FilterRegistration.Dynamic registration = servletContext.addFilter("filter", filter);
			registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");
		};
	}
}
