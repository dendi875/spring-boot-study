package com.zq.applicaiton;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 视频：3-11 SpringApplication 运行监听器事件监听器编程模型.mp4
 *
 * Spring Framework 中发送和监听事件示例
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-30 11:00:41
 */
public class SpringFrameworkEventBootstrap {

	public static void main(String[] args) {
		// 创建 Spring 应用上下文
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 添加事件监听器
		context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("监听到事件：" + event);
			}
		});

		// 刷新 Spring 应用上下文
		context.refresh();

		// 发送事件
		context.publishEvent("发送事件:HelloWorld");
		context.publishEvent("发送事件:SpringBoot");
		context.publishEvent(new ApplicationEvent("发送事件:张三") {

		});

		// 关闭 Spring 应用上下文
		context.close();
	}


}
