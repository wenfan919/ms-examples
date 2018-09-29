package com.yonyou.cloud.ms.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.cloud.ms.service.IChartDataService;
import com.yonyou.cloud.ms.service.IChartTypeService;
import com.yonyou.cloud.ms.service.INotifyService;

@Service
public class MsClientService {

	@Autowired
	private IChartDataService remoteDataService;

	@Autowired
	private IChartTypeService remoteTypeService;

	@Autowired(required=true)
	private INotifyService notifyService;

	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;

	public String getRemoteChartData(String type) throws Exception {
		
		//测试IUAP上下文传递时启用
		//com.yonyou.iuap.context.InvocationInfoProxy.setUsername("test-username");
		
		return remoteDataService.getChartDataByType(type);
	}

	public List<String> getRemoteChartType() throws Exception {
		return remoteTypeService.getChartTypes();
	}

	/**
	 * 操作图表类型
	 * 
	 * @param operator
	 *            操作符: add,del,select
	 * @param chartType
	 *            图表类型
	 * @return operator为select时返回所有的图表类型
	 */
	@Transactional
	public List<String> notifyChartType(String operator, String chartType) throws Exception {
		if ("add".equalsIgnoreCase(operator)) { //
			int update = jdbcTemplate.update("INSERT INTO biz_chart_type (charttype) VALUES(?)", chartType);
			if (update > 0) {
				notifyService.notify(INotifyService.ADD_CHART_TYPE + chartType);
			}
		} else if ("del".equalsIgnoreCase(operator)) {
			int update = jdbcTemplate.update("delete from biz_chart_type where charttype=?", chartType);
			if (update > 0) {
				notifyService.notify(INotifyService.DEL_CHART_TYPE + chartType);
			}
		} else if ("select".equalsIgnoreCase(operator)) {
			List<String> allChartTypes = notifyService.allChartTypes();
			return allChartTypes;
		}
		return null;
	}
}
