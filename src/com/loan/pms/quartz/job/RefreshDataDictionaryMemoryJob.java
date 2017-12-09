package com.loan.pms.quartz.job;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.loan.pms.common.service.CommonService;

public class RefreshDataDictionaryMemoryJob extends QuartzBaseJob{

	private static Logger logger = Logger.getLogger(RefreshDataDictionaryMemoryJob.class);
	
	@Resource(name=CommonService.SERVICE_ID)
	private CommonService commonService;
	
	@Override
	public void doJob() {
		logger.info("开始定时任务:刷新数据字典内存");
		commonService.refreshDataDictionaryMemory();
		logger.info("结束定时任务:刷新数据字典内存");
	}
}
