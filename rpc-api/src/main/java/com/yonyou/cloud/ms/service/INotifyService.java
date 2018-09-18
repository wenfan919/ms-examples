package com.yonyou.cloud.ms.service;

import java.util.List;

import com.yonyou.cloud.middleware.rpc.Async;
import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.ms.constants.AppInfoConstant;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiParam;

/**
 * EOS异步调用示例接口，rpc-client->rpc-provider，具体实现在provider
 * 
 * @author liujmc
 * @version 5.0.0-RELEASE
 */
@RemoteCall(AppInfoConstant.APP_INF_PROVIDER)
public interface INotifyService {

	public static final String ADD_CHART_TYPE = "addChartType:";
	public static final String DEL_CHART_TYPE = "delChartType:";

	/**
	 * 异步调用通知方法示例
	 */
	@Async
	public void notify(@ApiParam(name = "通知信息", required = true, description = "通知信息的具体内容字符串") String msg) throws Exception;

	/**
	 * @return 从DB中获取所有图表类型
	 */
	public List<String> allChartTypes();

}
