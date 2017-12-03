package com.loan.pms.quartz.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.loan.pms.common.utils.CommonFinal;
import com.loan.pms.system.web.controller.SystemController;

public abstract class QuartzBaseJob {
	
	private static Logger logger = Logger.getLogger(SystemController.class);
	
	@Value("${pms.quartz.switch}")
	public String quartzSwitch;
	
	public int lockMins;
	
	public void execute(){
		if(CommonFinal.TRUE.equals(quartzSwitch)){
			logger.info("定时任务开始:"+this.getClass().getName());
			invokeJob();
		}
	}
	public abstract void invokeJob();
	public void setLockMins(int lockMins) {
		this.lockMins = lockMins;
	}
}
