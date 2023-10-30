package com.zq.applicaiton.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 实现应用上下文初始化器，参考 spring-boot-autoconfigure META-INF/spring.factories
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-29 21:59:00
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements
		ApplicationContextInitializer<C> {

	@Override
	public void initialize(C applicationContext) {
		System.out.println("HelloWorldApplicationContextInitializer.id = " + applicationContext.getId());
	}
}
