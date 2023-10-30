package com.zq.applicaiton.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 自定义应用事件监听器，参数 spring-boot-autoconfigure META-INF/spring.factories # Application Listeners
 *
 * 借助 IDEA 工具 Find Usages 可以找到 ApplicationListener 具体在哪个 META-INF 里
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since 2023-10-30 10:32:35
 */
public class AfterApplicationListener
		implements ApplicationListener<ContextRefreshedEvent>, Ordered {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.printf("AfterApplicationListener : %s , timestamp: %s\n",
				event.getApplicationContext().getId(), event.getTimestamp());
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
}
