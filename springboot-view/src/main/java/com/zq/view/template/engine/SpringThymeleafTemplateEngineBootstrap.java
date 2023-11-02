package com.zq.view.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 视频：5-3 Thymeleaf 示例.mp4
 *
 * Thymeleaf 与 Spring 资源整合示例
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-01 17:39:42
 */
public class SpringThymeleafTemplateEngineBootstrap {

	public static void main(String[] args) throws IOException {
		// 构建引擎
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		// 创建渲染上下文
		Context context = new Context();
		context.setVariable("message", "Hello,World");

		// 读取内容从 classpath:/templates/thymeleaf/hello-world.html
		// ResourceLoader
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		// 通过 classpath:/templates/thymeleaf/hello-world.html Resource
		Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
		File templateFile = resource.getFile();
		// 文件流
		FileInputStream inputStream = new FileInputStream(templateFile);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// Copy
		IOUtils.copy(inputStream, outputStream);
		inputStream.close();
		String content = outputStream.toString("UTF-8"); // 模板的内容

		// 渲染（处理）结果
		String result = templateEngine.process(content, context);
		// 输出渲染（处理）结果
		System.out.println(result);
	}
}
