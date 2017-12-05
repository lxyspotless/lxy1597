package com.loan.pms.quartz.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.loan.pms.common.util.CommonFinal;

public abstract class QuartzBaseJob {
	
	private static Logger logger = Logger.getLogger(QuartzBaseJob.class);
	
	@Value("${pms.quartz.switch}")
	public String quartzSwitch;
	
	public int lockMins;
	
	public void execute(){
		// 开关已打开且系统已登录
		if(CommonFinal.TRUE.equals(quartzSwitch)){
			logger.info("定时任务开始:"+this.getClass().getName());
			try {
				doJob();
			} catch (Exception e) {
				logger.error("定时任务出错"+e.getMessage());
			}
			logger.info("定时任务结束:"+this.getClass().getName());
		}
	}
	
	public abstract void doJob()throws Exception;
	
	public void setLockMins(int lockMins) {
		this.lockMins = lockMins;
	}
}
