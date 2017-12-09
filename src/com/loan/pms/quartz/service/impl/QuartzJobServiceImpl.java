package com.loan.pms.quartz.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.quartz.dao.QuartzJobDao;
import com.loan.pms.quartz.dto.QuartzJobLockDTO;
import com.loan.pms.quartz.service.QuartzJobService;

@Service(QuartzJobService.SERVICE_ID)
public class QuartzJobServiceImpl implements QuartzJobService {

	@Autowired
	public QuartzJobDao quartzJobDao;
	
	@Override
	public boolean isLocked(QuartzJobLockDTO dto) {
		String resultStr = quartzJobDao.isJobLocked(dto);
		if(StringUtils.isEmpty(resultStr)){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void lockJob(QuartzJobLockDTO dto) {
		quartzJobDao.lockJob(dto);
	}

}
