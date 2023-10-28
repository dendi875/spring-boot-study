package com.zq.autoconfigure.service;

/**
 * 计算服务
 *
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-10-28 22:16:44
 */
public interface CalculateService {

	/**
	 * 求和
	 * @param values
	 * @return
	 */
	Integer sum(Integer... values);
}
