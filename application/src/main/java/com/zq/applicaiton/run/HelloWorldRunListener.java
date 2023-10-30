package com.zq.applicaiton.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义 Spring 运行监听器的实现，参考 SpringApplicationRunListener 的唯一实现 EventPublishingRunListener
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 11:43:04
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

	public HelloWorldRunListener(SpringApplication application, String[] args) {
	}

	@Override
	public void starting() {
		System.out.println("HelloWorldRunListener.starting()...");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {

	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {

	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {

	}

	@Override
	public void started(ConfigurableApplicationContext context) {

	}

	@Override
	public void running(ConfigurableApplicationContext context) {

	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {

	}
}
