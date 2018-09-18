package com.yonyou.cloud.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.yyeye.itf.Tracer;

@Service
public class ChartTypeServiceImpl implements IChartTypeService {

	@Override
	public List<String> getChartTypes() throws Exception {
		List<String> resultList = new ArrayList<String>();
		resultList.add("line");
		resultList.add("pie");
		resultList.add("bar");

		// 服务端-自定义业务埋点
		Tracer.setBusiCode("bizcode");

		return resultList;
	}

}
