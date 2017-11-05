package com.loan.pms.system.dao;

import java.util.List;
import java.util.Map;

import com.loan.pms.system.dto.SystemMenuDTO;

public interface SystemDao {

	/**
	 * 登录验证用户密码
	 * @param paramMap
	 * @return String
	 */
	String loginSystem(Map<String, Object> paramMap);
	
	/**
	 * 查询菜单列表
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> querySystemMenuList();
}
