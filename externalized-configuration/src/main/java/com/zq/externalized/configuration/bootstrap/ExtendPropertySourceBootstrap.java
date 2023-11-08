package com.zq.externalized.configuration.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

/**
 * 扩展外部化配置 {@link PropertySource} 引导类
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-08 11:05:36
 */
@EnableAutoConfiguration
@PropertySource(name="from classpath:META-INF/default.properties",value="classpath:META-INF/default.properties")//16.@PropertySource
public class ExtendPropertySourceBootstrap {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ExtendPropertySourceBootstrap.class)
				.web(WebApplicationType.NONE)
				.profiles("user.id=99")	// 17. Default properties
				.run(of("--user.id=100"));	// 4. Command line arguments.

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.out.println("用户id: " + environment.getProperty("user.id", Long.class));

		MutablePropertySources propertySources = environment.getPropertySources();
		int i = 0;
		for (org.springframework.core.env.PropertySource<?> propertySource : propertySources) {
			i++;
			System.out.printf("顺序[%d]-名称[%s]:[%s]\n", i, propertySource.getName(), propertySource.toString());
		}

		// 关闭 Spring 应用上下文
		applicationContext.close();
	}

	private static <T> T[] of(T... args) {
		return args;
	}
}
