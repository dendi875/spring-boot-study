package com.zq.autoconfigure.bootstrap;

import com.zq.autoconfigure.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * 视频：2-4 @Enable 模块装配两种方式.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 21:37:59
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

	public static void main(String[] args) {
		// 启动 Spring 应用上下文
		ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		// 通过依赖查找方式找 Bean
		String helloWorld = context.getBean("helloWorld", String.class);
		System.out.println(helloWorld);

		// 关闭 Spring 应用上下文
		context.close();
	}
}
