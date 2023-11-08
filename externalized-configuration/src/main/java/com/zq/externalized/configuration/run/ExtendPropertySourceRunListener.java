package com.zq.externalized.configuration.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于 SpringApplication 运行监听器扩展 PropertySource
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-08 10:57:29
 */
public class ExtendPropertySourceRunListener implements SpringApplicationRunListener, Ordered {

	private final SpringApplication application;

	private final String[] args;

	public ExtendPropertySourceRunListener(SpringApplication application, String[] args) {
		this.application = application;
		this.args = args;
	}

	@Override
	public void starting() {

	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		MutablePropertySources propertySources = environment.getPropertySources();

		Map<String, Object> map = new HashMap<>();
		map.put("user.id", 5);
		MapPropertySource propertySource = new MapPropertySource("from-SpringApplicationRunListener#environmentPrepared", map);

		propertySources.addFirst(propertySource);
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		ConfigurableEnvironment environment = context.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		Map<String, Object> map = new HashMap<>();
		map.put("user.id", 35);
		MapPropertySource propertySource = new MapPropertySource("from-SpringApplicationRunListener#contextPrepared", map);
		propertySources.addFirst(propertySource);
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		ConfigurableEnvironment environment = context.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();

		Map<String, Object> map = new HashMap<>();
		map.put("user.id", 45);
		MapPropertySource propertySource = new MapPropertySource("from-SpringApplicaitonRunListener#contextLoaded", map);
		propertySources.addFirst(propertySource);
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

	@Override
	public int getOrder() {
		return new EventPublishingRunListener(application, args).getOrder() - 1;
	}
}
