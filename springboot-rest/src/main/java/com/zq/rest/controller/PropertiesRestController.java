package com.zq.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

/**
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-02 16:39:22
 */
@Controller
public class PropertiesRestController {

	// produces 对应响应头中的 content-type
	// consumes 对应请求头中的 content-type
	@PostMapping(value = "/add/props",
			consumes = "text/properties;charset=UTF-8"
	)
	@ResponseBody
	public Properties addProperties(@RequestBody Properties properties) {
		return properties;
	}

	// 视频: 6-12 自定义 HandlerMethodArgumentResolver 实现.mp4
	// 不依赖 @RequestBody ， 实现 Properties 格式请求内容，解析为 Properties 对象的方法参数
	@PostMapping(value = "/add/props/arg/resolver",
			consumes = "text/properties;charset=UTF-8"
	)
	@ResponseBody
	public Properties addPropertiesArgumentResolver(Properties properties) {
		return properties;
	}

	// 视频: 6-13 自定义 HandlerMethodReturnValueHandler 实现.mp4
	// 不依赖 @ResponseBody ，实现 Properties 类型方法返回值，转化为 Properties 格式内容响应内容
	@PostMapping(value = "/add/props/return/handler",
			consumes = "text/properties;charset=UTF-8"
	)
	public Properties addPropertiesReturnHandler(Properties properties) {
		return properties;
	}
}
