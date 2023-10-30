package com.zq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * {@link org.springframework.web.servlet.mvc.Controller}
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 16:25:27
 */
@Controller
public class HelloWorldController {

	@RequestMapping("")
	public String index() {
		return "index";
	}
}
