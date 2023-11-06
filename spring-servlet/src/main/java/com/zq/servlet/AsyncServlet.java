package com.zq.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE;

/**
 * 自定义实现异步 Servlet
 *
 * 视频：7-13 异步 Servlet 实现.mp4
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-03 20:53:55
 */
@WebServlet(
		asyncSupported = true,
		name = "asyncServlet",
		urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 判断是否支持异步
		if (req.isAsyncSupported()) {
			// 创建 AsyncContext
			AsyncContext asyncContext = req.startAsync();
			// 设置超时时间
			asyncContext.setTimeout(50L);
			asyncContext.addListener(new AsyncListener() {
				@Override
				public void onComplete(AsyncEvent event) throws IOException {
					println("执行完成");
				}

				@Override
				public void onTimeout(AsyncEvent event) throws IOException {
					HttpServletResponse servletResponse = (HttpServletResponse)event.getSuppliedResponse();
					servletResponse.setStatus(SC_SERVICE_UNAVAILABLE);
					println("执行超时");
				}

				@Override
				public void onError(AsyncEvent event) throws IOException {
					println("执行错误");
				}

				@Override
				public void onStartAsync(AsyncEvent event) throws IOException {
					println("开始执行");
				}
			});

			println("Hello,World-1");

            ServletResponse servletResponse = asyncContext.getResponse();
            // 设置响应媒体类型
            servletResponse.setContentType("text/plain;charset=UTF-8");
            // 获取字符输出流
            PrintWriter writer = servletResponse.getWriter();
            writer.println("Hello,World-2");
            writer.flush();

		}

	}

	private static void println(Object object) {
		String threadName = Thread.currentThread().getName();
		System.out.println("AsyncServlet[" + threadName + "]: " + object);
	}
}
