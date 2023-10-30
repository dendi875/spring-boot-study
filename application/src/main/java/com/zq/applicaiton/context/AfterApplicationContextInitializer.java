package com.zq.applicaiton.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class AfterApplicationContextInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("AfterApplicationContextInitializer.id = " + applicationContext.getId());
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
}
