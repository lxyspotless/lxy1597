package com.loan.pms.quartz.job;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.loan.pms.common.util.CommonConstant;
import com.loan.pms.quartz.dto.QuartzJobLockDTO;
import com.loan.pms.quartz.service.QuartzJobService;
import com.loan.pms.quartz.util.QuartzConstant;

public abstract class QuartzBaseJob {
	
	private static Logger logger = Logger.getLogger(QuartzBaseJob.class);
	
	@Value("${pms.quartz.switch}")
	public String quartzSwitch;
	
	@Resource(name = QuartzJobService.SERVICE_ID)
	public QuartzJobService quartzService;
	
	//配置注入
	public int lockMins;
	
	public void execute(){
		// 开关已打开且系统已登录
		if(CommonConstant.TRUE.equals(quartzSwitch) && lockMins > 0){
			logger.info("定时任务开始:"+this.getClass().getName());
			Boolean isLocked = false;
			QuartzJobLockDTO dto = new QuartzJobLockDTO();
			dto.setTargetId(this.getClass().getName());
			dto.setTargetType(QuartzConstant.QUARTZ_TARGET_TYPE);
			// job处于非锁定状态，加锁再执行
			Date now = new Date();// new Date()为获取当前系统时间
			Timestamp nowStamp = new Timestamp(now.getTime());
			Timestamp afterStamp = new Timestamp(now.getTime() + lockMins*60*1000);
			dto.setLockedDate(nowStamp);
			dto.setExpiredDate(afterStamp);
			try {
				isLocked = quartzService.lockJob(dto);
				if(isLocked){// job加锁成功
					// 实现类定义方法
					doJob();
				}
			} catch (Exception e) {
				logger.error(String.format("定时任务%s出错:%s",this.getClass().getName(),e.getMessage()));
			} finally {
				// job锁失效(不管是否出错)
				Timestamp nowStampExpire = new Timestamp(new Date().getTime());
				dto.setExpiredDate(nowStampExpire);
				quartzService.expireJob(dto);
			}
			logger.info("定时任务结束:"+this.getClass().getName());
		}
	}
	
	/**
	 * 抽象方法，具体类中实现
	 * @throws Exception
	 */
	public abstract void doJob()throws Exception;
	
	public void setLockMins(int lockMins) {
		this.lockMins = lockMins;
	}
}
