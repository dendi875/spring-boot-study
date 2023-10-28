package com.zq.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 实现
 *
 * @author <a href="mailto:zhangquan@hupu.com">zhangquan</a>
 * @since  2023-10-28 22:18:23
 */
@Service
@Profile("Java8")
public class Java8CalculateService implements CalculateService {

	@Override
	public Integer sum(Integer... values) {
		System.out.println("Java 8 实现");

		return Stream.of(values).reduce(0, Integer::sum);
	}

	public static void main(String[] args) {
		CalculateService calculateService = new Java8CalculateService();
		System.out.println("CalculateService.sum(1...5) = " + calculateService.sum(1, 2, 3, 4, 5));
	}
}
