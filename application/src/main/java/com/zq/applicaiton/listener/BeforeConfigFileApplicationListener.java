package com.zq.applicaiton.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
 * 自定义 Spring Boot 事件监听器的实现示例，参考  ConfigFileApplicationListener 的实现
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 11:58:04
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
				|| ApplicationPreparedEvent.class.isAssignableFrom(eventType);
	}

	@Override
	public boolean supportsSourceType(Class<?> aClass) {
		return true;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationEnvironmentPreparedEvent) {
			ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
			Environment environment = preparedEvent.getEnvironment();
			System.out.println("environment.getProperty(\"name\") : " + environment.getProperty("name"));
		}
		if (event instanceof ApplicationPreparedEvent) {

		}
	}

	@Override
	public int getOrder() {
		return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
	}
}
