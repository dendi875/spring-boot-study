package com.zq.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 视频：4-10 Web MVC 常用注解（下）.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 18:22:20
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

	@ModelAttribute("acceptLanguage")
	public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
		return acceptLanguage;
	}

	@ModelAttribute("jsessionId")
	public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
		return jsessionId;
	}

	@ModelAttribute("message")
	public String message(){
		return "Hello,World";
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> onException(Throwable throwable) {
		return ResponseEntity.ok(throwable.getMessage());
	}
}
