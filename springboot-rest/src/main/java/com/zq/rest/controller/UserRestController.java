package com.zq.rest.controller;

import com.zq.rest.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-02 16:39:22
 */
@RestController
public class UserRestController {

	// produces 对应响应头中的 content-type
	// produces = "application/json;charset=UTF-8"
	// produces = "application/json;charset=GBK"

	// consumes 对应请求头中的 content-type
	@PostMapping(value = "/echo/user", produces = "application/json;charset=UTF-8", consumes = "application/*;charset=UTF-8")
	public User user(@RequestBody User user) {
		return user;
	}
}
