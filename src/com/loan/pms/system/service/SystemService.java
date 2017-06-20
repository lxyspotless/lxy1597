package com.loan.pms.system.service;

import java.util.Map;

public interface SystemService {
	
	public String SERVICE_ID = "pms.systemService";
	
	public boolean loginSystem(Map<String, Object> paramMap);
}
