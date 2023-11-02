package com.zq.rest.config;

import com.zq.rest.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		//converters.add(new PropertiesHttpMessageConverter()); // 不建议添加到 converters 的末尾
		converters.set(0, new PropertiesHttpMessageConverter()); // 添加到集合首位
	}
}
