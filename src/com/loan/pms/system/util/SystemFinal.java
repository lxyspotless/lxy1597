package com.loan.pms.system.util;

public interface SystemFinal {
	// 登录用户名
	public static final String LOGIN_USERNAME = "loginUserName";
	// 登录密码
	public static final String LOGIN_PASSWORD = "loginPassWord";
	// 登录用户名不能为空
	public static final String LOGIN_ERROR_USER_NULL = "登录用户名不能为空";
	// 登录密码不能为空
	public static final String LOGIN_ERROR_PASS_NULL = "登录密码不能为空";
	// 账号或密码错误
	public static final String LOGIN_ERROR_LOGIN_FAILED = "账号或密码错误";
	
	// 登录用户上次动作时间
	public static final String LAST_ACTIVE_TIME = "lastActiveTime";
	// 登录是否超时
	public static final String IS_SESSION_TIME_OUT = "IsSessionTimeOut";
	// 标识YES
	public static final String YES = "Y";
}
