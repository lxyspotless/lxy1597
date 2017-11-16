package com.loan.pms.system.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Login system - begin");
		String user = (String)request.getSession().getAttribute(SystemFinal.LOGIN_USERNAME);
		// 已登录则直接跳转
		if(!StringUtils.isEmpty(user)){
			ModelAndView mav = new ModelAndView();
			String userName = systemService.queryUserName(user);
			List<SystemMenuDTO> menuList = systemService.querySystemMenuList();
			//indexView.view主布局名称
			mav.setViewName("indexView.view");
			mav.addObject("userName",userName);
			mav.addObject("menuList",menuList);
			return mav;
		}
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
			}else{
				// 登录成功，将用户名写入session
				request.getSession().setAttribute(SystemFinal.LOGIN_USERNAME, loginUserName);
				// 将当前时间写入session
				request.getSession().setAttribute(SystemFinal.LAST_ACTIVE_TIME, System.currentTimeMillis());
			}
		}
		// 根据错误信息failedMsg判断要返回的页面
		ModelAndView mav = new ModelAndView();
		// 根据failedMsg是否为空判断登录是否成功
		if(StringUtils.isEmpty(failedMsg)){
			logger.info("login system success:"+loginUserName);
			//indexView.view主布局名称
			mav.setViewName("indexView.view");
			menuList = systemService.querySystemMenuList();
			mav.addObject("menuList",menuList);
			mav.addObject("userName",userName);
		} else {
			// 登录失败
			logger.info("login system failed:"+loginUserName);
			mav.setViewName("login");
			mav.addObject("faildMsg",failedMsg);
		}
		logger.info("Login system - end");
		return mav;
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 用户退出，将session销毁
		request.getSession().invalidate();
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

	@RequestMapping(value = "/queryDicCodeItem.json", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> queryDicCodeItem(HttpServletRequest request, HttpServletResponse response){
		String codeNo = request.getParameter("codeNo");
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		logger.info("查询数据字典类型:" + codeNo);
		if(!StringUtils.isEmpty(codeNo)) {
			resultList = systemService.queryDicCodeItem(codeNo);
		}
		return resultList;
	}
}
