package com.loan.pms.system.service;

import java.util.List;

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
	 * 获取登录用户
	 * @return
	 */
	public String getLoginUser();
	
	/**
	 * 设置登录用户
	 * @param loginUser
	 */
	public void setLoginUser(String loginUser);
}
