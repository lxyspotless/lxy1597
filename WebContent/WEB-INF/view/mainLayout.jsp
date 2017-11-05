<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>信贷产品配置管理系统</title>
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
	<style>
		.link_button{
			height:21px;
			line-height:21px;
			padding:0 11px;
			background:#e8e8e8;
			border:1px #dddddd solid;
			border-redius:3px;
			display:inline-block;
			text-decoration:none;
			font-size:12px;
			outline:none;
		}
	</style>
</head>
<body>
	<div id="mainContainer" class="easyui-layout" data-options="fit:true,multiple:true">
		<div data-options="region:'north',border:true,split:false" class="hdz_northheight" style="height:10%;background:#79CDCD;
			padding:10px;background-image:url(image/layout.jpg)">
			<div style="margin-top:20px; margin-left:80%">
				<a id='userName' data-option="plain:true" target="_top" >欢迎你：${userName}&nbsp;&nbsp;&nbsp;</a>
				<a id='logoutLink' href="javascript:void(0);" class="easyui-linkbutton" data-option="plain:true" target="_top"
					onclick="top.location.href='logout.do'" style="color:#ffff; ">注销</a>
			</div>
		</div>
		
		<div data-options="region:'west',split:false,title:'导航菜单',collapsed:false" 
			class="hdz_size hdz_westwidth" style="width:15%;border:0;background:#84C1FF">
			<div id="leftMenu" class="easyui-accordion" data-options="fit:false,border:true,multiple:true,collapsible:false">
				<c:forEach var="item" items="${menuList}" varStatus="status">
					<c:if test="${item.parentCode == null}">
						<!-- 第一个主菜单默认展开 -->
						<c:if test="${status.first}">
							<div title="'${item.menuName}'" data-options="id:'${item.menuCode}',title:'${item.menuName}'
								,selected:true" style="overflow:auto;text-align:center;padding-top:10px;padding-bottom:10px">
								<c:if test="${item.childMenu != null}">
									<c:forEach var="child" items="${item.childMenu}">
										<a id="${child.menuCode}" href="javascript:void(0)" class="easyui-linkbutton"
										style="text-align:left;width:99%;padding-left:20px;scrolling=no"
										onClick="addTab('${child.menuCode}','${child.menuName}','${child.menuAction}')" 
										 data-options="plain:true">
											&nbsp;<font size="2">${child.menuName}</font>
										</a>
									</c:forEach>
								</c:if>
							</div>
						</c:if>
						<!-- 其他主菜单默认关闭 ，代码只是少了selected:true -->
						<c:if test="${!status.first}">
							<div title="'${item.menuName}'" data-options="id:'${item.menuCode}',title:'${item.menuName}'"
								style="overflow:auto;text-align:center;padding-top:10px;padding-bottom:10px">
								<c:if test="${item.childMenu != null}">
									<c:forEach var="child" items="${item.childMenu}">
										<a id="${child.menuCode}" href="javascript:void(0)" class="easyui-linkbutton"
										style="text-align:left;width:99%;padding-left:20px;"
										onClick="addTab('${child.menuCode}','${child.menuName}','${child.menuAction}')" 
										data-options="plain:true">
											&nbsp;<font size="2">${child.menuName}</font>
										</a>
									</c:forEach>
								</c:if>
							</div>
						</c:if>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div id='centerArea' data-options="region:'center',title:'信贷产品配置管理平台'" class="easyui-tabs">	</div>
		<div data-options="region:'south',border:false" style="height:4%;background:#BBFFFF;padding:10px;text-align:center">CopyRight@Neo 2017</div>
	</div>
	<!-- <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:15%;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:5%;background:#BBFFFF;padding:10px;">south region</div> -->
	
</body>
<script type="text/javascript">
	var tabManager;
	$(function(){
		tabManager = $('centerArea').tabs({
			fit : true,
			custom : {
				contextMenu : {
					isShow : true
				}
			}
		}).tabs('followCustomHandle');
		debugger;
	});
	
	function addTab(tabid, title, url) {
		debugger;
		if ($('#centerArea').tabs('exists', title)){
			$('#centerArea').tabs('select', title);
		} else {
			var tabManager = $('#centerArea').tabs({
				fit : true,
				customAttr : {
					contextMenu : {
						isShow : true
					}
				}
			}).tabs();
			//var url = 'head.jsp';
			var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:88%;border:0;"></iframe>';
			var a = $.extend({href : url}, {});
			var opts = {
				id : tabid,
				title : title,
				href : url,
				tabWidth : 130,
				closable : true,
				border : false,
				fit : true
			};
			//tabManager.tabs('add', opts);
			$('#centerArea').tabs('add', opts);
		}
		/* _addTab(tabid, text, $.extend({
			href : url
		}));
		if (tabManager.tabs('exists', tabid)){
			tabManager.tabs('select', tabid);
		} else {
			//url = 'WEB-INF/view/head.jsp';
			var content = '<iframe scrolling="auto" frameborder="0"  src='+url+'" style="width:100%;height:100%;"></iframe>';
			tabManager.tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		} 
		$.get('/forwardView.do', {url : url}, function(data) {
			alert(data);});
		addTab(tabid, text, $.extend({
			href : url,
			//屏幕权限拦截字符串显示在tab中
			onLoad : function(panel) {
				if(panel[0] == "{limit:1}") {
					tabManager.tabs("close", tabManager.tabs("tabs").length - 1);
				}
			},
			onResize : function(width, height) {
				if(resizeMethodObj[tabid]) {
					setTimeout(resizeMethodObj[tabid],1000);
				}
			},
			onDestroy : function() {
				if(tabid == 'querySubDetail') {
					$('#productTermLabel input').remove();
				}
			}
		}, options))*/
	}
	
	function _addTab(tabid, text, options) {
		//var id = _uniform(tabid);
		if(tabManager.tabs('exists', text)) {
			tabManager.tabs('select', text);
		} else {
			tabManager.tabs('add', $.extend({
				id : tabid,
				title : text,
				closable : true,
				helpContext : text
			}, options));
			tabManager.tabs('getTab', text).attr("paneltitle", text);
		}
	}
</script>
</html>