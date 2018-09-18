package com.yonyou.cloud.ms.service;

import java.util.List;

import com.yonyou.cloud.mwclient.servmeta.annotation.ApiReturnValue;

/**
 * 获取图表类型列表服务<br>
 * 此示例不使用RemoteCall注解，使用spring配置文件的方式配置远程的bean
 * 
 * @author liujmc
 * @version 5.0.0-RELEASE
 */
public interface IChartTypeService {
	
	/**
	 * 远程获取echart图表类型列表
	 * 
	 * @return echarts的图表类型list
	 */
	public @ApiReturnValue(name="图表类型列表", description="示例中支持的 echarts demo的图表类型") List<String> getChartTypes() throws Exception;
}
