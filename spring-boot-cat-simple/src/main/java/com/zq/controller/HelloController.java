package com.zq.controller;

import com.zq.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// @RestController 的意思是 Controller 里面的方法都以 json 格式输出
@RestController
public class HelloController {

    @Autowired
    private CatService catServiceImpl;

    @RequestMapping("/hello")
    public String index(HttpServletRequest request) {
        String url = request.getRequestURL().toString();

        return catServiceImpl.hello(url);
    }

    @RequestMapping("/hello/error")
    public String error(HttpServletRequest request) {
        String url = request.getRequestURL().toString();

        return catServiceImpl.error(url);
    }
}
