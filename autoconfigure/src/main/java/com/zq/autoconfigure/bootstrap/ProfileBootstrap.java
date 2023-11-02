package com.zq.autoconfigure.bootstrap;

import com.zq.autoconfigure.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 视频：2-6 基于配置方式实现自定义条件装配.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 22:25:06
 */
@SpringBootApplication(scanBasePackages = "com.zq.autoconfigure.service")
public class ProfileBootstrap {

	public static void main(String[] args) {
		// 构造函数中传了 CalculateServiceBootstrap.class 就相当于在本类加上了 @Configuration 注解
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ProfileBootstrap.class)
				.web(WebApplicationType.NONE)
				.profiles("Java8")
				.run(args);

		// 依赖查找方式找 Bean
		CalculateService calculateService = context.getBean(CalculateService.class);
		System.out.println(calculateService.sum(1, 2, 3, 4, 5));

		// 关闭 Spring 上下文
		context.close();
	}
}
