package com.loan.pms.system.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.loan.pms.system.util.SystemFinal;

public class SessionTimeOutFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Long lastActiveTime = (Long) request.getSession().getAttribute(SystemFinal.LAST_ACTIVE_TIME);
		// 未登录无需判断是否超时
		if(null != lastActiveTime){
			String loginOutTimeMin = this.getFilterConfig().getInitParameter("loginTimeOutMin");
			if(!StringUtils.isEmpty(loginOutTimeMin)){
				if(lastActiveTime + Long.parseLong(loginOutTimeMin)*60*1000 < System.currentTimeMillis()){
					// 超时，清空session并跳转登录页面
					request.getSession().removeAttribute(SystemFinal.LOGIN_USERNAME);
					request.getSession().removeAttribute(SystemFinal.LAST_ACTIVE_TIME);
					request.getSession().setAttribute(SystemFinal.IS_SESSION_TIME_OUT, SystemFinal.YES);
					PrintWriter writer = response.getWriter();
					writer.print("{sessionOutOfTime:0}");
					return;
				}else{
					// 未超时，将本次动作时间更新写入session
					request.getSession().setAttribute(SystemFinal.LAST_ACTIVE_TIME, System.currentTimeMillis());
				}
			}else{
				logger.error("获取过滤器初始:登录超时时间,为空！");
			}
		}
		filterChain.doFilter(request, response);
	}

}
