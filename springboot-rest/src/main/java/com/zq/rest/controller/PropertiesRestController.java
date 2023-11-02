package com.zq.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-02 16:39:22
 */
@RestController
public class PropertiesRestController {

	// produces 对应响应头中的 content-type
	// consumes 对应请求头中的 content-type
	@PostMapping(value = "/add/props",
			consumes = "text/properties;charset=UTF-8"
	)
	public Properties addProperties(@RequestBody Properties properties) {
		return properties;
	}
}
