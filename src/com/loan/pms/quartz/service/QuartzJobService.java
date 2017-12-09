package com.loan.pms.quartz.service;

import com.loan.pms.quartz.dto.QuartzJobLockDTO;

public interface QuartzJobService {
	
	public String SERVICE_ID = "pms.quartz.QuartzJobService";
	/**
	 * 判断该job是否被锁定
	 * @param paramMap
	 * @return
	 */
	public boolean isLocked(QuartzJobLockDTO dto);
	
	/**
	 * 锁定job
	 * @param dto
	 */
	public void lockJob(QuartzJobLockDTO dto);
}
