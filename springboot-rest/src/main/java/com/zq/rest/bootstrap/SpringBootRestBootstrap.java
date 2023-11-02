package com.zq.rest.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 视频：第6章 Web MVC REST 应用
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since 2023-11-02 10:56:27
 */
@SpringBootApplication(scanBasePackages = {"com.zq.rest.controller", "com.zq.rest.config"})
public class SpringBootRestBootstrap {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootRestBootstrap.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
	}
}
