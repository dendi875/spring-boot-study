package com.zq.boot.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 视频：7-19 构建应用.mp4
 *
 * Spring Boot 应用传统 Servlet 容器部署
 * 基本原理：
 * 		SpringBootServletInitializer
 *		Spring  3.1  + SPI WebApplicationInitializer
 * 		Servlet 3.0  + SPI ServletContainnerInitializer
 *
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-04 17:49:01
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(SpringBootServletBootstrap.class);
		return builder;
	}
}
