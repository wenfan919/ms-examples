package com.yonyou.cloud.ms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * spring-boot工程示例，服务具体实现，统计功能
 * 
 * @author liujmc
 * @version 5.0.0-RELEASE
 */
@Service
public class StatisticsService implements IStatisticsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsService.class);

	@Override
	public Boolean statisticCallInfo(String type, String ts) throws Exception {
		LOGGER.info("{} 类型的方法被调用，调用时间为{}.", type, ts);
		return true;
	}

}
