package com.yonyou.cloud.ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.ms.constants.AppInfoConstant;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiParam;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiReturnValue;

/**
 * spring-boot 方式实现的微服务提供方示例接口，对应的实现工程为rpc-server，三层调用的最后层
 * 
 * @author liujmc
 * @version 5.0.0-RELEASE
 */
@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface IStatisticsService {
	
	/**
	 * 实时记录各种类型调用的统计信息
	 * 
	 * @return 成功或失败标志
	 */
	public @ApiReturnValue(name="统计操作成功标志", description="各种类型调用的统计操作调用结果，成功的标记") Boolean statisticCallInfo(
		@ApiParam(name="调用类型", required=true, description="调用的类型，如bar、pie、line等", exampleValue="line") String type,
		@ApiParam(name="调用时间", required=true, description="方法调用时候的时间戳", exampleValue="1528179906199") String ts
	) throws Exception;

}
