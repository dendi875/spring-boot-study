package com.zq.overview;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 视频：1-7 传统 Servlet 应用.mp4
 *
 * http://localhost:8080/my/servlet
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-27 20:33:19
 */
@SpringBootApplication
//@ServletComponentScan(basePackages = "com.zq.overview.web.servlet")
public class OverviewSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverviewSpringBootApplication.class, args);
	}
}
