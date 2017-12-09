package com.loan.pms.quartz.dao;

import com.loan.pms.quartz.dto.QuartzJobLockDTO;

public interface QuartzJobDao {

	/**
	 * 任务是否锁定,返回null则为否(锁释放时间小于当前时间)
	 * @param dto
	 * @return boolean
	 */
	public String isJobLocked(QuartzJobLockDTO dto);
	
	/**
	 * 给job加锁
	 * @param dto
	 */
	public void lockJob(QuartzJobLockDTO dto);
}
