package com.zq.view.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 主要是映射 springboot-view/src/main/webapp/WEB-INF/jsp/index.jsp 中的变量值
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-01 18:52:10
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

	@ModelAttribute("acceptLanguage")
	public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
		return acceptLanguage;
	}

	@ModelAttribute("jsessionId")
	public String jsessionId(@CookieValue(value = "JSESSIONID", required = false) String jsessionId){
		return jsessionId;
	}

	@ModelAttribute("message")
	public String message(){
		return "Hello,JSP";
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> onException(Throwable throwable) {
		return ResponseEntity.ok(throwable.getMessage());
	}
}
