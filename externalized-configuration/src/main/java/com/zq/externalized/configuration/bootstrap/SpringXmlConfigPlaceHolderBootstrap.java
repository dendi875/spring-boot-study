package com.zq.externalized.configuration.bootstrap;

import com.zq.externalized.configuration.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 应用外部化配置: XML Bean 方式，传统 Spring 例子
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-06 20:11:54
 */
public class SpringXmlConfigPlaceHolderBootstrap {

	public static void main(String[] args) {
		String [] locations = new String[] {"META-INF/spring/spring-context.xml", "META-INF/spring/user-context.xml"};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(locations);

		// 通过依赖查找方式获取 Bean
		User user = context.getBean("user", User.class);
		System.out.println(user);

		// 关闭 Spring 应用上下文
		context.close();
	}
}
