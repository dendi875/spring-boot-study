package com.zq.autoconfigure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 22:34:50
 */
public class MyCondition implements Condition {

	// AnnotatedTypeMetadata 主要保存 @MyConditionalOnProperty 注解的信息，比如注解属性
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attributes = metadata.getAnnotationAttributes(MyConditionalOnProperty.class.getName());

		String name = (String) attributes.get("name");
		String value = (String) attributes.get("value");

		String sysValue = System.getProperty(name);

		return sysValue.equals(value);
	}
}
