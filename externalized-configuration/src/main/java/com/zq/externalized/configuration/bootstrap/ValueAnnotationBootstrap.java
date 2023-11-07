package com.zq.externalized.configuration.bootstrap;

import com.zq.externalized.configuration.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * 1. 外部化配置 @Value 注入方式
 * 2. 外部化配置 Environment 方式
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since 2023-11-07 16:28:32
 */
public class ValueAnnotationBootstrap implements EnvironmentAware {

	//private final Long id;
	//
	//private final String name;
	//
	//private final Integer age;

	@Autowired
	private Environment environment1;

	private Environment environment;

	private Environment environment3;

	@Autowired
	public ValueAnnotationBootstrap(Environment environment) {
		this.environment = environment;
	}

	//public ValueAnnotationBootstrap(@Value("${user.id}") Long id,
	//								@Value("${user.name}") String name,
	//								@Value("${user.age:${my.user.age:18}}") Integer age) {
	//	this.id = id;
	//	this.name = name;
	//	this.age = age;
	//}

	//@Bean
	//public User user() {
	//	User user = new User();
	//	user.setId(id);
	//	user.setName(name);
	//	user.setAge(age);
	//	return user;
	//}

	@Bean
	public User user2(@Value("${user.id}") Long id,
					  @Value("${user.name}") String name,
					  @Value("${user.age:${my.user.age:${your.user.age:88}}}") Integer age) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@Bean
	public User user3(Environment environment) {
		Long id = environment.getProperty("user.id", Long.class);
		String name = environment.getProperty("user.name");
		Integer age = environment.getProperty("user.age", Integer.class, 20);

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@Bean
	public User user4() {
		Long id = this.environment.getProperty("user.id", Long.class);
		String name = this.environment.getProperty("user.name");
		Integer age = this.environment.getProperty("user.age", Integer.class, 20);

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@Bean
	public User user5() {
		Long id = this.environment1.getProperty("user.id", Long.class);
		String name = this.environment1.getProperty("user.name");
		Integer age = this.environment1.getProperty("user.age", Integer.class, 20);

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@Bean
	public User user6() {
		Long id = this.environment3.getProperty("user.id", Long.class);
		String name = this.environment3.getProperty("user.name");
		Integer age = this.environment3.getProperty("user.age", Integer.class, 20);

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		return user;
	}

	public static void main(String[] args) {
		// 因为 new SpringApplicationBuilder(ValueAnnotationBootstrap.class)，指定了是引导类，
		// 所以框架帮我们配置了 Configuration Class，不然需要加上 @Configuration 注解
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ValueAnnotationBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);

		//User user = applicationContext.getBean("user", User.class);
		//System.out.println("用户对象 @Value 构造器注入 user：" + user);

		User user2 = applicationContext.getBean("user2", User.class);
		System.out.println("用户对象 @Value 方法注入 user2： " + user2);

		User user3 = applicationContext.getBean("user3", User.class);
		System.out.println("用户对象 Environment 方法注入 user3： " + user3);

		User user4 = applicationContext.getBean("user4", User.class);
		System.out.println("用户对象 Environment 构造器注入 user4： " + user4);

		User user5 = applicationContext.getBean("user5", User.class);
		System.out.println("用户对象 Environment 字段注入 user5： " + user5);

		User user6 = applicationContext.getBean("user6", User.class);
		System.out.println("用户对象 Environment 通过Aware回调接口注入 user6： " + user6);

		// 关闭 Spring 上下文
		applicationContext.close();
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment3 = environment;
	}
}
