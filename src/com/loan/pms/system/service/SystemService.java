package com.loan.pms.system.service;

import java.util.List;
import java.util.Map;

public interface SystemService {
	
	public String SERVICE_ID = "pms.systemService";
	
	/**
	 * 登录验证用户密码
	 * @param paramMap
	 * @return boolean
	 */
	public String loginSystem(String loginUserName, String loginPassWord);
	
	/**
	 * 查询菜单列表
	 * @return menuList
	 */
	public List<Map<String, Object>> querySystemMenuList(); 
}
