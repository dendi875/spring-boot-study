package com.zq.externalized.configuration.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since 2023-11-06 20:10:48
 */
@Validated
@ConfigurationProperties("user")
public class User {

	private Long id;

	private String name;

	//@Value("${user.age}")
	@NotNull
	private Integer age;

	private City city;

	private static class City {
		private String postCode;
		private String name;

		public String getPostCode() {
			return postCode;
		}

		public void setPostCode(String postCode) {
			this.postCode = postCode;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "City{" +
					"postCode='" + postCode + '\'' +
					", name='" + name + '\'' +
					'}';
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", city=" + city +
				'}';
	}
}
