package com.zq.rest.config;

import com.zq.rest.http.converter.properties.PropertiesHttpMessageConverter;
import com.zq.rest.method.support.PropertiesHandlerMethodArgumentResolver;
import com.zq.rest.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	@PostConstruct
	public void init() {
		// 获取当前 RequestMappingHandlerAdapter 所有的 Resolver 对象
		List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
		List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolvers.size() + 1);
		// 添加 PropertiesHandlerMethodArgumentResolver 到集合首位
		newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
		// 添加 已注册的 Resolver 对象集合
		newResolvers.addAll(resolvers);
		// 重新设置 Resolver 对象集合
		requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);


		// 获取当前 HandlerMethodReturnValueHandler 所有的 Handler 对象
		List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
		List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(handlers.size() + 1);
		// 添加 PropertiesHandlerMethodReturnValueHandler 到集合首位
		newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
		// 添加 已注册的 Handler 对象集合
		newHandlers.addAll(handlers);
		// 重新设置 Handler 对象集合
		requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);
	}


	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// 添加 PropertiesHandlerMethodArgumentResolver 到集合首位
		// 添加自定义 HandlerMethodArgumentResolver，优先级低于内建 HandlerMethodArgumentResolver，所以这种方式不行
		// 需要 @PostConstruct 里做这块逻辑
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver(0));
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }

	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}

	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		//converters.add(new PropertiesHttpMessageConverter()); // 不建议添加到 converters 的末尾
		// converters.set(0, new PropertiesHttpMessageConverter()); // 添加到集合首位
	}
}
