package com.zq.autoconfigure.bootstrap;

import com.zq.autoconfigure.condition.MyConditionalOnProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * 通过 @Conditional 来实现自定义条件注解
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 22:39:16
 */

public class ConditionalBootstrap {

	@Bean
	@MyConditionalOnProperty(name = "user.name", value = "zhangquan") // 条件满足才会生成 Bean
	public String helloConditional() {
		return "hello, Conditional";
	}

	public static void main(String[] args) {
		// 构造函数中传了 ConditionalBootstrap.class 那么和在类上写 @Configuration 等效
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		// 依赖查找Bean，通过名称和类型方式
		String helloConditional = context.getBean("helloConditional", String.class);
		System.out.println(helloConditional);

		// 关闭 Spring 应用上下文
		context.close();
	}
}
