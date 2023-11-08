package com.zq.externalized.configuration.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过监听 ApplicationPreparedEvent 事件来扩展 PropertySource
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-08 14:33:56
 */
public class ExtendPropertySourceApplicationListener2 implements
		ApplicationListener<ApplicationPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		ConfigurableApplicationContext context = event.getApplicationContext();
		ConfigurableEnvironment environment = context.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();

		Map<String, Object> map = new HashMap<>();
		map.put("user.id", 100);
		MapPropertySource propertySource = new MapPropertySource("from-ExtendPropertySourceApplicationListener2", map);

		propertySources.addFirst(propertySource);
	}
}
