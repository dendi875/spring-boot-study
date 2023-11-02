package com.zq.rest.http.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties} {@link HttpMessageConverter} 实现自定义 HttpMessageConverter
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-02 18:16:21
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

	public PropertiesHttpMessageConverter() {
		super(new MediaType("text", "properties"));
	}

	@Override
	protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		// Properties -> String
		// OutputStream -> Writer
		HttpHeaders httpHeaders = outputMessage.getHeaders();
		MediaType mediaType = httpHeaders.getContentType();
		// 获取字符编码
		Charset charset = mediaType.getCharset();
		// 当 charset 不存在时，使用 UTF-8
		charset = charset == null ? Charset.forName("UTF-8") : charset;


		OutputStream outputStream = outputMessage.getBody(); // 字节输出流
		Writer writer = new OutputStreamWriter(outputStream, charset);  // 字节输出流 => 字符输出流

		// Properties 写入到字符输出流
		properties.store(writer,"From PropertiesHttpMessageConverter");
	}

	// 把文本转成对象
	@Override
	protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		// 从 请求头 Content-Type 解析编码
		HttpHeaders httpHeaders = inputMessage.getHeaders();
		MediaType mediaType = httpHeaders.getContentType();
		// 获取字符编码
		Charset charset = mediaType.getCharset();
		// 当 charset 不存在时，使用 UTF-8
		charset = charset == null ? Charset.forName("UTF-8") : charset;


		InputStream inputStream = inputMessage.getBody(); // 字节输入流
		InputStreamReader reader = new InputStreamReader(inputStream, charset); // 字节输入流 => 字符输入流

		Properties properties = new Properties();
		properties.load(reader); // 加载字符流成为 Properties 对象
		return properties;
	}

	@Override
	public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return readInternal(null, inputMessage);
	}
}
