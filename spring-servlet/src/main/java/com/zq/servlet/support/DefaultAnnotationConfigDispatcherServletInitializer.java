package com.zq.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 参考：/Users/zhangquan/code/github.com/spring-boot-study/spring-mvc
 *
 * Spring 适配
 * 		SpringServletContainerInitializer
 *
 * Spring SPI https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/spring-framework-reference/web.html#mvc-servlet-special-bean-types
 * 		基础接口： WebApplicationInitializer
 * 		XML驱动： AbstractDispatcherServletInitializer
 * 		注解驱动： AbstractAnnotationConfigDispatcherServletInitializer
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 18:51:20
 */
@ComponentScan(basePackages = "com.zq.servlet.controller")
public class DefaultAnnotationConfigDispatcherServletInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {	// 替代 web.xml
		return new Class[0];
	}

	/**
	 代替 spring-mvc/src/main/webapp/WEB-INF/web.xml 中的
	 <!--        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>-->
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{getClass()};  // 返回当前类
	}

	/**
	 代替 spring-mvc/src/main/webapp/WEB-INF/web.xml 中的
	 <!--    <servlet-mapping>-->@
	 <!--        <servlet-name>app</servlet-name>-->
	 <!--        <url-pattern>/</url-pattern>-->
	 <!--    </servlet-mapping>-->
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
