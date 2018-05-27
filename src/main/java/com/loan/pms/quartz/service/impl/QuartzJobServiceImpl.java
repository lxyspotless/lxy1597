package com.loan.pms.quartz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.common.util.CommonConstant;
import com.loan.pms.quartz.dao.QuartzJobDao;
import com.loan.pms.quartz.dto.QuartzJobLockDTO;
import com.loan.pms.quartz.service.QuartzJobService;

@Service(QuartzJobService.SERVICE_ID)
public class QuartzJobServiceImpl implements QuartzJobService {

	@Autowired
	public QuartzJobDao quartzJobDao;
	
	@Override
	public boolean lockJob(QuartzJobLockDTO dto) {
		boolean resultFlag = false;
		quartzJobDao.lockJob(dto);
		if(CommonConstant.Y.equals(dto.getIsLocked())){
			resultFlag = true;
		}
		return resultFlag;
	}

	@Override
	public void expireJob(QuartzJobLockDTO dto) {
		quartzJobDao.expireJob(dto);
	}

}
