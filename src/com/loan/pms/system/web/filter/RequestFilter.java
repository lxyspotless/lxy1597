package com.loan.pms.system.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.loan.pms.system.util.SystemFinal;

public class RequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// 检查是否已登录，如果否直接跳转到登录界面
		String requestUrl = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUrl.substring(contextPath.length());
		String userName = (String) request.getSession().getAttribute(SystemFinal.LOGIN_USERNAME);
		if(!url.endsWith("login.do") && !url.endsWith("logout.do") && StringUtils.isEmpty(userName)){
			//response.sendRedirect("login.jsp");
			//return;
		}
		chain.doFilter(request, response);

	}

}
