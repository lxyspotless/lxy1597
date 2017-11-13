package com.loan.pms.system.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loan.pms.system.dto.SystemMenuDTO;
import com.loan.pms.system.service.SystemService;
import com.loan.pms.system.util.SystemFinal;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class SystemController {
	
	private static Logger logger = Logger.getLogger(SystemController.class);
	
	@Resource(name = SystemService.SERVICE_ID)
	private SystemService systemService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Login system - begin");
		// 获取登录账号密码
		String loginUserName = request.getParameter(SystemFinal.LOGIN_USERNAME);
		String loginPassWord = request.getParameter(SystemFinal.LOGIN_PASSWORD);
		String failedMsg = "";
		String userName = "";
		List<SystemMenuDTO> menuList = new ArrayList<SystemMenuDTO>();
		// 判断账号密码是否有错
		if(StringUtils.isEmpty(loginUserName)){
			failedMsg = SystemFinal.LOGIN_ERROR_USER_NULL;
		}else if(StringUtils.isEmpty(loginPassWord)){
			failedMsg = SystemFinal.LOGIN_ERROR_PASS_NULL;
		}else{
			userName = systemService.loginSystem(loginUserName, loginPassWord);
			if(StringUtils.isEmpty(userName)){
				failedMsg = SystemFinal.LOGIN_ERROR_LOGIN_FAILED;
			}
		}
		// 根据错误信息failedMsg判断要返回的页面
		ModelAndView mav = new ModelAndView();
		// 根据failedMsg是否为空判断登录是否成功
		if(StringUtils.isEmpty(failedMsg)){
			logger.info("login system success:"+loginUserName);
			//indexView.view主布局名称
			mav.setViewName("indexView.view");
			//getMenuList(menuList);
			menuList = systemService.querySystemMenuList();
			mav.addObject("menuList",menuList);
			mav.addObject("userName",userName);
		} else {
			logger.info("login system failed:"+loginUserName);
			mav.setViewName("login");
			mav.addObject("faildMsg",failedMsg);
		}
		logger.info("Login system - end");
		return mav;
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("login.jsp");
		logger.info("exist system");
		return;
	}

	@RequestMapping(value = "/forwardView.do", method = RequestMethod.GET)
	public ModelAndView forwardView(HttpServletRequest request, HttpServletResponse response){
		String view = request.getParameter("view");
		logger.info("页面：" + view);
		ModelAndView mav = new ModelAndView();
		if(!StringUtils.isEmpty(view)) {
			mav.setViewName(view);
		}
		return mav;
	}

}
