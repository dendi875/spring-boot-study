package com.zq.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Java 7 实现
 *
 * @author <a href="mailto:zhangquan@hupu.com">zhangquan</a>
 * @since  2023-10-28 22:18:23
 */
@Service
@Profile("Java7")
public class Java7CalculateService implements CalculateService {

	@Override
	public Integer sum(Integer... values) {
		System.out.println("Java 7 实现");
		Integer sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		CalculateService calculateService = new Java7CalculateService();
		System.out.println("CalculateService.sum(1...5) = " + calculateService.sum(1, 2, 3, 4, 5));
	}
}
