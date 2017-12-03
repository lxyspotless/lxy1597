package com.loan.pms.quartz.job;

import org.apache.log4j.Logger;

import com.loan.pms.system.web.controller.SystemController;

public class RefreshDataDictionaryMemory extends QuartzBaseJob{

	private static Logger logger = Logger.getLogger(SystemController.class);

	@Override
	public void invokeJob() {
		logger.info("开始执行:");
		
	}
	
}
