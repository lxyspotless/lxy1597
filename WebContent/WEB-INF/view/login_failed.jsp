<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<form action="login.do" method="post">
	<div class="easyui-panel" style="width:350px;height:330px;padding:10px 10px;text-align:center;
		position: absolute;left:70%;top:45%;">
		<p style="font-size: xx-large; color:#11b0da; padding: 0px 0px 0px; position: relative;">
			产品配置平台<br>
		</p>
		<div style="margin-bottom:20px">
			<input name="username" class="easyui-textbox" prompt="输入用户名" iconWidth="30" style="width:300px;height:35px;padding:10px;">
		</div>
		<div style="margin-bottom:20px">
			<input name="password" class="easyui-passwordbox" prompt="输入密码" iconWidth="30" style="width:300px;height:35px;padding:10px">
		</div>
		<input type="submit" value="登录" style="width: 48px; height: 30px; border: 0; background-color:#11b0da;cursor: pointer;"/>
		<div id="error">
			<p style="color:#ff0000; position: relative;">账号或密码错误</p>
		</div>
	</div>
	</form>
</body>
</html>