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
		map.put("MENU_CODE", "A");
		map.put("MENU_NAME", "产品管理");
		map.put("MENU_ACTION", "");
		menuList.add(map);
		Map<String, Object> map1 = new HashMap<String,Object>();
		map1.put("MENU_CODE", "A1");
		map1.put("MENU_NAME", "销售产品管理");
		map1.put("PARENT_CODE", "A");
		map1.put("MENU_ACTION", "forward/saleProductDetaol.do");
		map1.put("MENU_OPEN_MODE","yes");
		menuList.add(map1);
	}
}
