<%@ page language="java" pageEncoding="UTF-8"%>
<div id="subProductList_div" style="padding:5px;">
	<div id="subProductSearchPanel" style="padding:5px;">
	<table>
		<tr>
			<td>业务条线：</td>
			<td><input id="subProductList_businessLine" style="width:150px"></td>
			<td>销售产品：</td>
			<td><input id="subProductList_saleProductNo" style="width:150px"></td>
		</tr>
		<tr>
			<td>产品编号：</td>
			<td><input id="subProductList_productNo" style="width:150px"></td>
			<td>产品名称：</td>
			<td><input id="subProductList_productName" style="width:150px"></td>
		</tr>
		<tr>
			<td>是否有效：</td>
			<td><input id="subProductList_status" style="width:150px"></td>
		</tr>
	</table>
	</div>
	<div id="subProductListDataTable"></div>
</div>

<script type="text/javascript">
seajs.use('./product/js/subProductList.js',function(subProductList){
	subProductList.init($('#subProductList_div'));
});
</script>