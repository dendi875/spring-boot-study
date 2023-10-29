package com.zq.autoconfigure.configuration;

import com.zq.autoconfigure.annotation.EnableHelloWorld;
import com.zq.autoconfigure.condition.MyConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的自动装配实现示例
 *
 * 第一步：增加 Spring 模式注解，比如 @Configuration
 * 第二步：可以复用 Spring @Enable 模块装配
 * 第三步：使用 条件装配
 *
 * 通过 DEBUG 发现由以下三步完成：
 * 首先会进行条件判断由@MyConditionalOnProperty 完成
 * 然后条件满足后激活 @Enable 模块装配
 * 最后当引导类启动之后，helloWorld Bean 应该被自动装配掉
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-29 16:28:29
 */
@Configuration
@EnableHelloWorld
@MyConditionalOnProperty(name = "user.name", value = "zhangquan")
public class HelloWordAutoConfiguration {
}
