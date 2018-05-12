package com.loan.pms.quartz.service;

import com.loan.pms.quartz.dto.QuartzJobLockDTO;

public interface QuartzJobService {
	
	public String SERVICE_ID = "pms.quartz.QuartzJobService";
	/**
	 * 锁定job
	 * @param paramMap
	 * @return
	 */
	public boolean lockJob(QuartzJobLockDTO dto);
	
	/**
	 * 释放job锁
	 * @param dto
	 */
	public void expireJob(QuartzJobLockDTO dto);
}
