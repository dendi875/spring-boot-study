package com.zq.view.template.engine;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * 视频：5-3 Thymeleaf 示例.mp4
 *
 * 使用 Thymeleaf API 渲染内容示例
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-01 17:39:20
 */
public class ThymeleafTemplateEngineBootstrap {

	public static void main(String[] args) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();

		// 创建渲染上下文
		Context context = new Context();
		context.setVariable("message", "Hello,World");
		// 模板的内容
		String content = "<p th:text=\"${message}\">!!!</p>";
		// 渲染（处理）结果
		String result = templateEngine.process(content, context);
		// 输出渲染（处理）结果
		System.out.println(result);
	}
}
