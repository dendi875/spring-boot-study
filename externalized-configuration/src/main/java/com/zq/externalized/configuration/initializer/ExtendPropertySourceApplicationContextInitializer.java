package com.zq.externalized.configuration.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 通过 Spring 应用上下文初始化器来扩展 PropertySource
 *
 * 参考：/Users/zhangquan/code/github.com/spring-boot-study/application/src/main/java/com/zq/applicaiton/context/HelloWorldApplicationContextInitializer.java
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-08 11:58:19
 */
public class ExtendPropertySourceApplicationContextInitializer implements ApplicationContextInitializer {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext.getEnvironment();

		MutablePropertySources propertySources = environment.getPropertySources();

		Map<String, Object> map = new HashMap<>();
		map.put("user.id", 25);

		MapPropertySource propertySource = new MapPropertySource("from-ApplicationContextInitializer", map);
		propertySources.addFirst(propertySource);
	}
}
