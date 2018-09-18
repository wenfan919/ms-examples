package com.yonyou.cloud.ms.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.cloud.ms.listener.CustomServletContextListener;

@Service
public class ChartDataServiceImpl implements IChartDataService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChartDataServiceImpl.class);
	
	@Autowired
	IStatisticsService statisticsService;

	@Override
	public String getChartDataByType(String type) throws Exception {
		
		//测试iuap上下文传递时候启用
		//LOGGER.info("来自于调用方的IUAP上下文信息为：{}.", com.yonyou.iuap.context.InvocationInfoProxy.getUsername());
		
		try {
			//调用统计服务
			statisticsService.statisticCallInfo(type, String.valueOf(System.currentTimeMillis()));
		} catch (Exception e) {
			LOGGER.error("调用统计服务失败!");
		}
		
		//调用本地服务，返回json数据
		String ctxPath = CustomServletContextListener.CTX_REAL_PATH;
		String json = FileUtils.readFileToString(new File(ctxPath + File.separator + "data" + File.separator + type + ".json"),"utf-8");
		return json;
	}
    
}
