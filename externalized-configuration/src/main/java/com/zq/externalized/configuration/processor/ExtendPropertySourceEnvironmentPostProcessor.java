package com.zq.externalized.configuration.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 通过 EnvironmentPostProcessor 来扩展 PropertySource
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-08 11:46:29
 */
public class ExtendPropertySourceEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		MutablePropertySources propertySources = environment.getPropertySources();
		Map<String, Object> map = new HashMap<>();
		map.put("user.id", 16);
		MapPropertySource propertySource = new MapPropertySource("from-EnvironmentPostProcessor", map);
		propertySources.addFirst(propertySource);
	}

	@Override
	public int getOrder() {
		return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
	}
}
