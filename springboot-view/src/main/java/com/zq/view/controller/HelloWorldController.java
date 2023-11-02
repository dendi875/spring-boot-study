package com.zq.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-01 18:02:34
 */
@Controller
public class HelloWorldController {

	@RequestMapping("")
	public String index(@RequestParam(required = false, defaultValue = "0") int value, Model model) {
		return "index";
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "hello-world"; // View 逻辑名称
	}

	@ModelAttribute("message") // 替换  templates/thymeleaf/hello-world.html  ${message} 变量
	public String message() {
		return "Hello,Thymeleaf";
	}
}
