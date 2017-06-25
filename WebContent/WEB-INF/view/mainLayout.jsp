<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>信贷产品配置系统</title>
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body id="bodyContainer" class="easyui-layout" data-option="fit:true">
	<div data-options="region:'north',border:false" style="height:15%;background:#A9FACD;padding:10px">north region
	</div>
	<div data-options="region:'west',split:true,title:'信贷产品配置平台',collapsed:false" class="hdz_size hdz_westwidth"
		style="width:18%;font-family:雅黑;font-size:18px;border:0;color:#FFFFFF;background:#84C1FF;">
		<div id="leftmenu" class="easyui-accordion" data-options="fit:false,border:false.multiple:true">
			<div>
			<c:forEach var="item" items="${menuList}" varStatus="status">
				<c:if test="${item.PARENT_CODE == null}">
			</div>
					<c:if test="${status.first}">
						<div title="'${item.MENU_NAME}'" data-options="id:'${item.MENU_CODE}',title:'${item.MENU_NAME}'
							,selected:true" style="text-align:center;padding-top:10px;padding-bottom:10px;">
						</div>
					</c:if>
					<c:if test="${!status.first}">
						<div title="'${item.MENU_NAME}'" data-options="id:'${item.MENU_CODE}',title:'${item.MENU_NAME}'"
							style="background:#84C1FF;text-align:center;padding-top:10px;padding-bottom:10px;">
						</div>
					</c:if>
				</c:if>
				<c:if test="${item.PARENT_CODE != null}">
					<div class="hdz_icon">
						<a id="${item.MENU_CODE}" href="#" class="easyui-linkbutton hdz_icon_plus"
							style="text-align:left;width:80%;padding-left:30px;"
							 data-options="plain:true">
								&nbsp;
							<font style="color:#FFFFFF" size="2">${item.MENU_NAME}</font>
						</a>
					</div>
					<div style="height:5px"></div>
				</c:if>
			</c:forEach>
			
		</div>
	</div>
	<!-- <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:15%;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:5%;background:#BBFFFF;padding:10px;">south region
	</div> -->
	<div data-options="region:'center',title:'Detail'">
		<div class="easyui-tabs" data-options="fit:true,border:false,plain:true"></div>
	</div>
</body>
</html>