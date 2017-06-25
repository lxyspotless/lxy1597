package com.loan.pms.system.web.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loan.pms.system.service.SystemService;

import org.springframework.stereotype.Controller;

@Controller
public class SystemController {
	
	@Resource(name = SystemService.SERVICE_ID)
	private SystemService systemService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login1(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		ArrayList<Map<String, Object>> menuList = new ArrayList<Map<String,Object>>();
		paramMap.put("umId", null==username?"":username.toUpperCase());
		paramMap.put("passWord", request.getParameter("password"));
		if(systemService.loginSystem(paramMap)){
			ModelAndView mav = new ModelAndView("indexView");
			getMenuList(menuList);
			mav.addObject("menuList",menuList);
			return mav;
		}else{
			ModelAndView mav = new ModelAndView("login_failed");
			return mav;
		}
	}
	
	private void getMenuList(List<Map<String, Object>> menuList){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("SORT_NO", "1");
		map.put("MENU_CODE", "PMS10001");
		map.put("MENU_NAME", "产品配置");
		map.put("PARENT_CODE", "");
		map.put("MENU_ACTION", "");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "1");
		map.put("MENU_CODE", "PMS100010001");
		map.put("MENU_NAME", "销售产品管理");
		map.put("PARENT_CODE", "PMS10001");
		map.put("MENU_ACTION", "forward.do?view=saleProductList.view");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "2");
		map.put("MENU_CODE", "PMS100010002");
		map.put("MENU_NAME", "产品信息管理");
		map.put("PARENT_CODE", "PMS10001");
		map.put("MENU_ACTION", "forward.do?view=subProductList.view");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "1");
		map.put("MENU_CODE", "PMS10002");
		map.put("MENU_NAME", "版本管理");
		map.put("PARENT_CODE", "");
		map.put("MENU_ACTION", "");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "1");
		map.put("MENU_CODE", "PMS100020001");
		map.put("MENU_NAME", "产品复制");
		map.put("PARENT_CODE", "PMS10002");
		map.put("MENU_ACTION", "forward.do?view=productCopy.view");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "2");
		map.put("MENU_CODE", "PMS100020003");
		map.put("MENU_NAME", "产品版本管理");
		map.put("PARENT_CODE", "PMS10002");
		map.put("MENU_ACTION", "forward.do?view=productVersionManager.view");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "3");
		map.put("MENU_CODE", "PMS100020004");
		map.put("MENU_NAME", "产品复核");
		map.put("PARENT_CODE", "PMS10002");
		map.put("MENU_ACTION", "forward.do?view=productCheck.view");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "4");
		map.put("MENU_CODE", "PMS100020004");
		map.put("MENU_NAME", "产品审核");
		map.put("PARENT_CODE", "PMS10002");
		map.put("MENU_ACTION", "forward.do?view=productApprove.view");
		menuList.add(map);
		map = new HashMap<String,Object>();
		map.put("SORT_NO", "5");
		map.put("MENU_CODE", "PMS100020005");
		map.put("MENU_NAME", "产品发布");
		map.put("PARENT_CODE", "PMS10002");
		map.put("MENU_ACTION", "forward.do?view=productRelease.view");
		menuList.add(map);
	}
}
