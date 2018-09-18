package com.yonyou.cloud.ms.client.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.ms.client.service.MsClientService;

@RestController
@RequestMapping(value = "/types")
public class ChartTypeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChartTypeController.class);

	@Autowired
	private MsClientService clientService;

	@RequestMapping(value = "/list")
	public List<String> getLineOption(HttpServletRequest request) {
		List<String> list = null;
		try {
			list = clientService.getRemoteChartType();
		} catch (Exception e) {
			LOGGER.error("获取图表类型报错!", e);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("error_code", "500");
			result.put("error_message", "获取图表类型报错!");
		}
		return list;
	}

	@RequestMapping(value = "/notifyChartType")
	@ResponseBody
	public Object notifyChartType(String operator, String chartType) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<String> ret = clientService.notifyChartType(operator, chartType);
			if (null != ret) {
				return ret;
			}
			result.put("code", "200");
			result.put("message", operator + "图表类型成功!");
		} catch (Exception e) {
			LOGGER.error("获取图表类型报错!", e);
			result.put("error_code", "500");
			result.put("error_message", operator + "图表类型报错!");
		}
		return result;
	}

}
