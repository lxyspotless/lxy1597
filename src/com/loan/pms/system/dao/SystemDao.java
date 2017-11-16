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
	public String loginSystem(Map<String, Object> paramMap);

	/**
	 * 查询用户名称
	 * @param String
	 * @return String
	 */
	public String queryUserName(String loginUserName);
	
	/**
	 * 查询菜单列表
	 * @return List<Map<String, Object>>
	 */
	public List<SystemMenuDTO> querySystemMenuList();
	
	/**
	 * 查询数据字典下该codeNo所有数据
	 * @param codeNo
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> queryDicCodeItem(String codeNo);
}
