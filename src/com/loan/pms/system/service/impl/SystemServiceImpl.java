package com.loan.pms.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.system.dao.SystemDao;
import com.loan.pms.system.dto.SystemMenuDTO;
import com.loan.pms.system.service.SystemService;

@Service(SystemService.SERVICE_ID)
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private SystemDao systemDao;
	
	private static Logger logger = Logger.getLogger(SystemServiceImpl.class);
	
	
	@Override
	public String loginSystem(String loginUserName, String loginPassWord) {
		// 验证用户密码
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("umId", null==loginUserName?"":loginUserName.toUpperCase());
		paramMap.put("passWord", loginPassWord);
		String userName = systemDao.loginSystem(paramMap);
		logger.info("登录用户:"+userName);
		return userName;
	}

	@Override
	public String queryUserName(String loginUserName) {
		return systemDao.queryUserName(loginUserName);
	}

	@Override
	public List<SystemMenuDTO> querySystemMenuList() {
		// 查询菜单列表
		List<SystemMenuDTO> menuList = systemDao.querySystemMenuList();
		List<SystemMenuDTO> resultMenuList = new ArrayList<SystemMenuDTO>();
		if(null != menuList && menuList.size() > 0) {
			List<SystemMenuDTO> childMenuList = new ArrayList<SystemMenuDTO>();
			for(int i = 0 ; i < menuList.size() ; i++) {
				// 主菜单,先保存将子菜单加入到childMenu中
				if(null == menuList.get(i).getParentCode()) {
					// 将主菜单放入resultMenuList
					resultMenuList.add(menuList.get(i));
					// 将上次加入的主菜单放入子菜单
					if(resultMenuList.size() > 1) {
						resultMenuList.get(resultMenuList.size() - 2).setChildMenu(childMenuList);
						childMenuList = new ArrayList<SystemMenuDTO>();
					}
				} else {
					// 子菜单拼接,SQL中已排序
					childMenuList.add(menuList.get(i));
				}
				// 最后一个主菜单,放入子菜单
				if(i == menuList.size() - 1) {
					resultMenuList.get(resultMenuList.size() - 1).setChildMenu(childMenuList);
				}
			}
			logger.info("系统菜单数:"+menuList.size());
		}
		return resultMenuList;
	}

	@Override
	public List<Map<String, Object>> queryDicCodeItem(String codeNo) {
		return systemDao.queryDicCodeItem(codeNo);
	}

}
