package com.zq.applicaiton.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 自定义应用事件监听器，参数 spring-boot-autoconfigure META-INF/spring.factories # Application Listeners
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 10:32:35
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.printf("HelloWorldApplicationListener : %s , timestamp: %s\n",
				event.getApplicationContext().getId(), event.getTimestamp());
	}
}
