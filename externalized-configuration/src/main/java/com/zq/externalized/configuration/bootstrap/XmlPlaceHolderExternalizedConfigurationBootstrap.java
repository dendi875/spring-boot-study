package com.zq.externalized.configuration.bootstrap;

import com.zq.externalized.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * 应用外部化配置: XML Bean 方式， Spring Boot 例子
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-06 20:22:19
 */
@ImportResource("classpath:/META-INF/spring/user-context.xml")
@EnableAutoConfiguration
public class XmlPlaceHolderExternalizedConfigurationBootstrap {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(XmlPlaceHolderExternalizedConfigurationBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		User user = applicationContext.getBean("user", User.class);
		System.out.println(user);
		System.out.println("系统变量：" + System.getProperty("user.name"));

		// 关闭 Spring 应用上下文
		applicationContext.close();
	}
}
