package com.zq.mvc.servlet.support;

import com.zq.mvc.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 4-12 Web MVC 自动装配实现.mp4
 *
 * Spring 适配
 * 		SpringServletContainerInitializer
 *
 * Spring SPI
 * 		基础接口： WebApplicationInitializer
 * 		编程驱动： AbstractDispatcherServletInitializer
 * 		注解驱动： AbstractAnnotationConfigDispatcherServletInitializer
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 18:51:20
 */
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
		return new Class[]{DispatcherServletConfiguration.class};
	}

	/**
	 代替 spring-mvc/src/main/webapp/WEB-INF/web.xml 中的
	 <!--    <servlet-mapping>-->
	 <!--        <servlet-name>app</servlet-name>-->
	 <!--        <url-pattern>/</url-pattern>-->
	 <!--    </servlet-mapping>-->
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
