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
		Long lastActiveTime = (Long) request.getSession().getAttribute(SystemFinal.LAST_ACTIVE_TIME);
		// (未登&需拦截请求)|登录超时，重定向到登录界面
		if((StringUtils.isEmpty(userName) && !isExcludedUrl(url)) || isLoginOutOfTime(lastActiveTime, request)){
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
			return;
		}
		chain.doFilter(request, response);

	}

	/**
	 * 判断是否是例外的URL，无需登录即可访问
	 * @param url
	 * @return
	 */
	private boolean isLoginOutOfTime(Long lastActiveTime, HttpServletRequest request){
		boolean resultFlag = false;
		// 未登录无需判断是否超时
		if(null != lastActiveTime){
			String loginOutTimeMin = this.getFilterConfig().getInitParameter("loginOutTimeMin");
			if(!StringUtils.isEmpty(loginOutTimeMin)){
				if(lastActiveTime + Long.parseLong(loginOutTimeMin)*60*1000 < System.currentTimeMillis()){
					resultFlag = true;
				}else{
					// 未超时，将本次动作时间更新写入session
					request.getSession().setAttribute(SystemFinal.LAST_ACTIVE_TIME, System.currentTimeMillis());
				}
			}else{
				logger.error("获取过滤器初始:登录超时时间,为空！");
			}
		}
		return resultFlag;
	}
	
	/**
	 * 判断是否是例外的URL，无需登录即可访问
	 * @param url
	 * @return
	 */
	private boolean isExcludedUrl(String url){
		String excludedUrls = this.getFilterConfig().getInitParameter("exclude");
		if(!StringUtils.isEmpty(excludedUrls)){
			String[] excludedUrlArr = excludedUrls.split(";");
			if(null != excludedUrlArr){
				for(String excludedUrl : excludedUrlArr){
					if(url.endsWith(excludedUrl)){
						return true;
					}
				}
			}else{
				logger.error("获取过滤器初始:例外URL,错误！");
			}
		}else{
			logger.error("获取过滤器初始:例外URL,为空！");
		}
		return false;
	}
}
