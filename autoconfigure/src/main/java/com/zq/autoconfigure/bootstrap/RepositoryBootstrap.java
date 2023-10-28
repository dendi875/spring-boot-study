package com.zq.autoconfigure.bootstrap;

import com.zq.autoconfigure.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 视频：2-3 Spring Framework 手动装配自定义模式注解.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 20:07:58
 */
@ComponentScan("com.zq.autoconfigure.repository") // 指定扫描特定 package 下被 Spring 模式注解标记的类
public class RepositoryBootstrap {

	public static void main(String[] args) {
		// 启动 Spring 上下文
		ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		// 依赖查找方式获取 Bean
		MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

		System.out.println("myFirstLevelRepository = " + myFirstLevelRepository);

		// 关闭 Spring 上下文
		context.close();
	}
}
