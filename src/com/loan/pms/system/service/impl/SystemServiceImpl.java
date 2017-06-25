package com.loan.pms.system.service.impl;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.system.dao.SystemDao;
import com.loan.pms.system.service.SystemService;

@Service(SystemService.SERVICE_ID)
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private SystemDao systemDao;
	
	@Override
	public boolean loginSystem(Map<String, Object> paramMap) {
		// TODO
		String org_code = systemDao.loginSystem(paramMap);
		System.out.println(org_code);
		if(null == org_code){
			return false;
		} else {
			return true;
		}
	}

}
