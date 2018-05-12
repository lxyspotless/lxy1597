<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	/*String flag = (String)session.getAttribute("flag")==null?"":(String)session.getAttribute("flag");  
	String name = "";  
	String password = "";  
	try{   
	    Cookie[] cookies = request.getCookies();   
	    if(cookies != null){
	    for(int i=0; i<cookies.length; i++){
	        if(cookies[i].getName().equals("cookie_pms_user")){
		        String value = cookies[i].getValue();
		        if(value!=null && !"".equals(value)){
	            	name = cookies[i].getValue().split(":")[0];
		            if(cookies[i].getValue().split(":")[1] != null
						&& !cookies[i].getValue().split(":")[1].equals("null")){
		     			password = cookies[i].getValue().split(":")[1];   
		            }
		        }
	        }
	    	request.setAttribute("name",name);
	        request.setAttribute("passward",password);
	    }   
	    }   
	}catch(Exception e){   
	    e.printStackTrace();   
	}*/
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>信贷产品配置系统</title>
</head>

<body style="padding: 0;background-image:url(image/login_back.jpg);background-repeat:no-repeat;background-size:100%;">
	<div class="login">
	<form action="login.do" method="post">
	<div class="easyui-panel" style="width:300px;height:330px;padding:10px 10px;text-align:center;
		position: absolute;left:70%;top:45%;">
		<p style="font-size: xx-large; color:#11b0da; padding: 0px 0px 0px; position: relative;">
			产品配置平台<br>
		</p>
		<div style="margin-bottom:20px">
			<input name="loginUserName" class="easyui-textbox" prompt="输入用户名" iconWidth="30" style="width:250px;height:35px;padding:10px;">
		</div>
		<div style="margin-bottom:20px">
			<input name="loginPassWord" class="easyui-passwordbox" prompt="输入密码" iconWidth="30" style="width:250px;height:35px;padding:10px">
		</div>
		<input type="submit" value="登录" style="width: 48px; height: 30px; border: 0; background-color:#11b0da;cursor: pointer;"/>
		<p style="color:#ff0000;">${faildMsg}</p>
	</div>
	</form>
	</div>
</body>
</html>