package com.zq.autoconfigure.bootstrap;

import com.zq.autoconfigure.configuration.HelloWordAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 自动装配
 *
 * Spring Boot 的自动装配还是基于 Spring Framework 实现，不过在些基础上增加了 /META-INF/spring.factories
 *
 * <p>
 * 在 Spring Boot 场景下，基于约定大于配置的原则，实现 Spring 组件自动装配的目的。其中使用了：
 * 底层装配技术
 * 1. Spring 模式注解装配  	@Configuration
 * 2. Spring @Enable 模块装配 @EnableHelloWorld
 * 3. Spring 条件装配装配 	@MyConditionalOnProperty
 * 4. Spring 工厂加载机制
 * 实现类： SpringFactoriesLoader
 * 配置资源： META-INF/spring.factories
 * <p>
 * 自动装配举例：参考 META-INF/spring.factories
 * <p>
 * 自定义自动装配步骤：
 * 1. 激活自动装配：@EnableAutoConfiguration
 * 2. 实现自定义装配：XXXAutoConfiguration
 * 3. 配置自动装配实现：META-INF/spring.factories
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @see HelloWordAutoConfiguration
 * @since 2023-10-29 16:21:46
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

	public static void main(String[] args) {
		// 启动 Spring 应用上下文
		ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		// 依赖查找方式找Bean (名称+类型找)
		String helloWord = context.getBean("helloWorld", String.class);
		System.out.println("=============>" + helloWord);

		// 关闭 Spring 应用上下文
		context.close();
	}
}
