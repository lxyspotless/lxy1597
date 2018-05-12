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
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Login system - begin");
		String user = (String)request.getSession().getAttribute(SystemFinal.LOGIN_USERNAME);
		String isSeesionTimeOut = (String)request.getSession().getAttribute(SystemFinal.IS_SESSION_TIME_OUT);
		ModelAndView mAndView = new ModelAndView();
		// 登录已超时
		if(!StringUtils.isEmpty(isSeesionTimeOut)){
			logger.info("Login session time out");
			request.getSession().invalidate();
			mAndView.setViewName("login");
		// 已登录则直接跳转
		}else if(!StringUtils.isEmpty(user)){
			logger.info("Already Login"+user);
			String userName = systemService.queryUserName(user);
			List<SystemMenuDTO> menuList = systemService.querySystemMenuList();
			//indexView.view主布局名称
			mAndView.setViewName("indexView.view");
			mAndView.addObject("userName",userName);
			mAndView.addObject("menuList",menuList);
		}else{	// 正常登录
			// 获取登录账号密码
			String loginUserName = request.getParameter(SystemFinal.LOGIN_USERNAME);
			String loginPassWord = request.getParameter(SystemFinal.LOGIN_PASSWORD);
			String failedMsg = "";
			String userName = "";
			List<SystemMenuDTO> menuList = new ArrayList<SystemMenuDTO>();
			// 判断账号密码是否有错
			if(StringUtils.isEmpty(loginUserName)){
				// 账户名不能为空
				failedMsg = SystemFinal.LOGIN_ERROR_USER_NULL;
			}else if(StringUtils.isEmpty(loginPassWord)){
				// 登录密码不能为空
				failedMsg = SystemFinal.LOGIN_ERROR_PASS_NULL;
			}else{
				userName = systemService.loginSystem(loginUserName, loginPassWord);
				if(StringUtils.isEmpty(userName)){
					// 账号密码错误
					failedMsg = SystemFinal.LOGIN_ERROR_LOGIN_FAILED;
				}else{
					// 登录成功，将用户名写入session
					request.getSession().setAttribute(SystemFinal.LOGIN_USERNAME, loginUserName);
					// 将当前时间写入session
					request.getSession().setAttribute(SystemFinal.LAST_ACTIVE_TIME, System.currentTimeMillis());
					// 去除登录已超时
					request.getSession().removeAttribute(SystemFinal.IS_SESSION_TIME_OUT);
					// 设置登录用户
					systemService.setLoginUser(userName);
				}
			}
			// 根据failedMsg是否为空判断登录是否成功
			if(StringUtils.isEmpty(failedMsg)){
				logger.info("login system success:"+loginUserName);
				//indexView.view主布局名称
				mAndView.setViewName("indexView.view");
				menuList = systemService.querySystemMenuList();
				mAndView.addObject("menuList",menuList);
				mAndView.addObject("userName",userName);
			} else {
				// 登录失败
				logger.info(loginUserName+"login system failed:"+failedMsg);
				mAndView.setViewName("login");
				mAndView.addObject("faildMsg",failedMsg);
			}
		}
		logger.info("Login system - end");
		return mAndView;
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 用户退出，将session内容清除
		request.getSession().removeAttribute(SystemFinal.LOGIN_USERNAME);
		request.getSession().removeAttribute(SystemFinal.LAST_ACTIVE_TIME);
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
		ModelAndView mAndView = new ModelAndView();
		mAndView.setViewName("login");
		// 清空登录用户
		systemService.setLoginUser(null);
		logger.info("exist system");
		return;
	}

	@RequestMapping(value = "/forwardView.do", method = RequestMethod.GET)
	public ModelAndView forwardView(HttpServletRequest request, HttpServletResponse response){
		String view = request.getParameter("view");
		logger.info("页面：" + view);
		ModelAndView mAndView = new ModelAndView();
		if(!StringUtils.isEmpty(view)) {
			mAndView.setViewName(view);
		}
		return mAndView;
	}

}
