package com.zq.externalized.configuration.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过监听 Spring Boot 事件中的 ApplicationEnvironmentPreparedEvent 事件，来扩展 PropertySource
 * <p>
 * 参考: spring-boot-study/application/src/main/java/com/zq/applicaiton/listener/BeforeConfigFileApplicationListener.java
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since 2023-11-08 11:27:47
 */
public class ExtendPropertySourceApplicationListener implements SmartApplicationListener {

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType) ||
				ApplicationPreparedEvent.class.isAssignableFrom(eventType);
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return true;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationEnvironmentPreparedEvent) {
			ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
			ConfigurableEnvironment environment = preparedEvent.getEnvironment();
			MutablePropertySources propertySources = environment.getPropertySources();

			Map<String, Object> map = new HashMap<>();
			map.put("user.id", 6);
			MapPropertySource propertySource = new MapPropertySource("from-ApplicationEnvironmentPreparedEvent", map);

			propertySources.addFirst(propertySource);
		}
		if (event instanceof ApplicationPreparedEvent) {

		}
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
