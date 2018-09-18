package com.yonyou.cloud.ms.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * EOC框架异步调用示例实现类
 * 
 * @author liujmc
 * @version 5.0.0-RELEASE
 */
@Service
public class NotifyService implements INotifyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotifyService.class);

	@Autowired(required=false)
	private JdbcTemplate jdbcTemplate;

	@Override
	public void notify(String msg) throws Exception {
		int update = 0;
		if (StringUtils.startsWith(msg, ADD_CHART_TYPE)) {
			String chartType = StringUtils.removeStart(msg, ADD_CHART_TYPE);
			update = jdbcTemplate.update("INSERT INTO biz_chart_type (charttype) VALUES(?)", chartType);
		} else if (StringUtils.startsWith(msg, DEL_CHART_TYPE)) {
			String chartType = StringUtils.removeStart(msg, DEL_CHART_TYPE);
			update = jdbcTemplate.update("delete from biz_chart_type where charttype=?", chartType);
		}
		LOGGER.info("rpc-provider 接收到来自eos的通知，通知内容为：{}, 执行结果:{}", update);
	}

	@Override
	public List<String> allChartTypes() {
		return jdbcTemplate.queryForList("select charttype from biz_chart_type ", String.class);
	}

}
