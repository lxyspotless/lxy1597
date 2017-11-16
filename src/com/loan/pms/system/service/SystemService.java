package com.loan.pms.system.service;

import java.util.List;
import java.util.Map;

import com.loan.pms.system.dto.SystemMenuDTO;

public interface SystemService {
	
	public String SERVICE_ID = "pms.system.systemService";
	
	/**
	 * 登录验证用户密码
	 * @param loginUserName
	 * @param loginPassWord
	 * @return String
	 */
	public String loginSystem(String loginUserName, String loginPassWord);

	/**
	 * 查询用户名称
	 * @param String
	 * @return String
	 */
	public String queryUserName(String loginUserName);
	
	/**
	 * 查询菜单列表
	 * @return menuList
	 */
	public List<SystemMenuDTO> querySystemMenuList();
	
	/**
	 * 查询数据字典下该codeNo所有数据
	 * @param codeNo
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> queryDicCodeItem(String codeNo);
}
