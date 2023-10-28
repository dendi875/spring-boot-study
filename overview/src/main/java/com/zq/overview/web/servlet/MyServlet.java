//package com.zq.overview.web.servlet;
//
//import javax.servlet.AsyncContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 视频：1-7 传统 Servlet 应用.mp4
// *
// * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
// * @since  2023-10-27 21:42:53
// */
//@WebServlet(urlPatterns = "/my/servlet", asyncSupported = true)
//public class MyServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		// 包含 tomcat 或 jetty 的同步使用
//		resp.getWriter().println("Hello, World");
//
//		// 包含 tomcat 或 jetty 异步使用
//		//AsyncContext asyncContext = req.startAsync();
//		//asyncContext.start(() -> {
//		//	try {
//		//		resp.getWriter().println("Hello, World");
//		//
//		//		// 这步很重要，需要触发完成
//		//		asyncContext.complete();
//		//	} catch (IOException e) {
//		//		e.printStackTrace();
//		//	}
//		//
//		//});
//	}}
