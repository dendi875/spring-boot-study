package com.zq.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-02 10:57:47
 */
@RestController
public class HelloWorldRestController {

	@GetMapping("/hello-world")
	public String helloWorld(@RequestParam(required = false) String message) {
		return "Hello, World: " + message;
	}
}
