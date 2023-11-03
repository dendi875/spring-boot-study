package com.zq.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视频：6-14 REST 内容协商CORS.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-02 21:35:59
 */
@Controller
public class CrossOriginController {

	@RequestMapping("")
	public String index() {
		return "index"; // 返回 thymeleaf 模板 index
	}

}
