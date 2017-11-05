package com.loan.pms.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.pms.system.dao.SystemDao;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> querySystemMenuList() {
		// 查询菜单列表
		List<Map<String, Object>> menuList = systemDao.querySystemMenuList();
		List<Map<String, Object>> resultMenuList = new ArrayList<Map<String, Object>>();
		if(null != menuList && menuList.size() > 0) {
			List<Map<String, Object>> childMenuList = new ArrayList<Map<String, Object>>();
			for(int i = 0 ; i < menuList.size() ; i++) {
				// 主菜单,先保存将子菜单加入到childMenu中
				if(null == menuList.get(i).get("parentCode")) {
					// 将主菜单放入resultMenuList
					resultMenuList.add(menuList.get(i));
					// 将上次加入的主菜单放入子菜单
					if(resultMenuList.size() > 1) {
						resultMenuList.get(resultMenuList.size() - 2).put("childMenu", childMenuList);
						childMenuList = new ArrayList<Map<String, Object>>();
					}
				} else {
					// 子菜单拼接,SQL中已排序
					childMenuList.add(menuList.get(i));
				}
				// 最后一个主菜单,放入子菜单
				if(i == menuList.size() - 1) {
					resultMenuList.get(resultMenuList.size() - 1).put("childMenu", childMenuList);
				}
			}
			logger.info("系统菜单数:"+menuList.size());
		}
		return resultMenuList;
	}

}
