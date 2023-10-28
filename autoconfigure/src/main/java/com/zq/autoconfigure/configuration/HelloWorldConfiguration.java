package com.zq.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 21:36:00
 */
@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String helloWorld() {
		return "Hello, World";
	}
}
