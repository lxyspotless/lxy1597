package com.loan.pms.quartz.dao;

import com.loan.pms.quartz.dto.QuartzJobLockDTO;

public interface QuartzJobDao {

	/**
	 * 锁定job,返回Y则成功，N失败(锁释放时间大于当前时间)
	 * @param dto
	 * @return boolean
	 */
	public void lockJob(QuartzJobLockDTO dto);
	
	/**
	 * 释放job加锁
	 * @param dto
	 */
	public void expireJob(QuartzJobLockDTO dto);
}
