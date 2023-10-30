package com.zq.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注解方式配置 Spring MVC
 *
 * 基本配置步骤
 * 	1. 注解配置： @Configuration （ Spring 范式注解 ）
 *  2. 组件激活： @EnableWebMvc （Spring 模块装配）
 *  3. 自定义组件 ： WebMvcConfigurer （Spring Bean）
 *
 * 4-6 Web MVC 注解驱动.mp4
 * 4-8 WebMvcConfigurer 注入过程.mp4
 *
 * @EnableWebMvc 这个注解替代
 * spring-mvc/src/main/webapp/WEB-INF/app-context.xml 中的实现
 * <!--    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>-->
 * <!--    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>-->
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 17:30:40
 */
@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 代替 spring-mvc/src/main/webapp/WEB-INF/app-context.xml 中的实现
	 <!--    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
	 <!--        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
	 <!--        <property name="prefix" value="/WEB-INF/jsp/"/>-->
	 <!--        <property name="suffix" value=".jsp"/>-->
	 <!--    </bean>-->
	 */
	//@Bean
	//public ViewResolver viewResolver(){
	//	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	//	viewResolver.setViewClass(JstlView.class);
	//	viewResolver.setPrefix("/WEB-INF/jsp/");
	//	viewResolver.setSuffix(".jsp");
	//	return viewResolver;
	//}

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
}
