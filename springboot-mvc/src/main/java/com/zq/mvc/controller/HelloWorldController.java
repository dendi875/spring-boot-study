package com.zq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * {@link org.springframework.web.servlet.mvc.Controller}
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 16:25:27
 */
@Controller
public class HelloWorldController {

	@RequestMapping("")
	public String index(@RequestParam int value, Model model) {
		//model.addAttribute("acceptLanguage",acceptLanguage);
        //model.addAttribute("jsessionId",jsessionId);
        //model.addAttribute("message","Hello,World");
		return "index";
	}
}
