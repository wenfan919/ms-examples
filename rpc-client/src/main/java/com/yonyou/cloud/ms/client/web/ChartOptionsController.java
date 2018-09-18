package com.yonyou.cloud.ms.client.web;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.ms.client.service.MsClientService;

@RestController
@RequestMapping(value = "/options")
public class ChartOptionsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChartOptionsController.class);

	@Autowired
	private MsClientService clientService;
	
	@RequestMapping(value = "/line")
	public String getLineOption(HttpServletRequest request) {
		String json = "";
		try {
			json = clientService.getRemoteChartData("line");
		} catch (Exception e) {
			LOGGER.error("获取line的图表初始化数据失败!", e);
		}
		return json;
	}
	
	@RequestMapping(value = "/pie")
	public String getPieOption(ServletRequest request) {
		String json = "";
		try {
			json = clientService.getRemoteChartData("pie");
		} catch (Exception e) {
			LOGGER.error("获取饼图初始化数据失败!", e);
		}
		return json;
	}
	
	@RequestMapping(value = "/bar")
	public String getBarOption(ServletRequest request) {
		String json = "";
		try {
			json = clientService.getRemoteChartData("bar");
		} catch (Exception e) {
			LOGGER.error("获取柱状图初始化数据失败!", e);
		}
		return json;
	}

}
