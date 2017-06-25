<%@ page language="java" pageEncoding="UTF-8"%>
<div id="leftMenu" class="easyui-accordion" data-options="fit:true,border:false">
	<c:forEach var="item" items="${menuList}">
		<c:if test="${item.parent_code == null}">
			<div title="${item.menu_name}" data-options="id:${item.menu_code},title:${item.menu_name}"
				style="padding:10px;">
			</div>
		</c:if>
	</c:forEach>
				
</div>