package com.zq.mvc.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * {@link org.springframework.web.servlet.DispatcherServlet } 配置类
 *
 * 代替 spring-mvc/src/main/webapp/WEB-INF/app-context.xml 中的实现:
 * <context:component-scan base-package="com.zq.mvc"/>
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 18:55:36
 */
@ComponentScan(basePackages = "com.zq.mvc")
public class DispatcherServletConfiguration {
}
