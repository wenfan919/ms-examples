package com.yonyou.cloud.ms.service;

import com.wordnik.swagger.annotations.ApiOperation;
import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.ms.constants.AppInfoConstant;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiParam;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiReturnValue;

/**
 * 普通的同步RPC调用的示例
 * 
 * @author liujmc
 * @version 5.0.0-RELEASE
 */
@RemoteCall(AppInfoConstant.APP_INF_PROVIDER)
public interface IChartDataService {
	
	/**
	 * 远程获取echart的各种图表的json数据
	 * 
	 * @param type line/pie/bar
	 * @return echarts的json数据
	 */
	@ApiOperation("根据类型获取各种echarts图表的数据")
	public @ApiReturnValue(name="json 数据", description="echarts 需要的option数据，详情请参考echarts官网文档") String getChartDataByType(@ApiParam(name="图表类型", required=true, description="图表类型数据文件前缀，如bar、pie、line等", exampleValue="line") String type) throws Exception;
}
