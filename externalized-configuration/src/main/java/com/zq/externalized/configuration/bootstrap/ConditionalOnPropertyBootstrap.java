package com.zq.externalized.configuration.bootstrap;

import com.zq.externalized.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 外部化配置 @ConfigurationProperties 绑定方式
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-07 18:27:31
 */
@EnableAutoConfiguration
public class ConditionalOnPropertyBootstrap {

	@Bean
	@ConfigurationProperties("user")
	@ConditionalOnProperty(value = "user.city.post_code", matchIfMissing = true, havingValue = "4000")
	public User user() {
		return new User();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ConditionalOnPropertyBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		//User user = applicationContext.getBean("user", User.class);
		//System.out.println("用户对象 @ConfigurationProperties 绑定方式 user: " + user);

		User user = applicationContext.getBean(User.class);
		System.out.println("用户对象 user: " + user);

		// 关闭 Spring 应用上下文
		applicationContext.close();
	}
}
