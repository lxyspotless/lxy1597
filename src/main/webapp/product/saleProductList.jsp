<%@ page language="java" pageEncoding="UTF-8"%>
<div id="saleProductList_div" style="padding:5px;">
	<div id="saleProductSearchPanel" style="padding:5px;">
	<table>
		<tr>
			<td>业务条线：</td>
			<td><input id="saleProductList_businessLine" style="width:150px"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>销售产品名称：</td>
			<td><input id="saleProductList_saleProductName" style="width:150px"></td>
		</tr>
	</table>
	</div>
	<div id="saleProductListDataTable"></div>
</div>

<script type="text/javascript">
seajs.use('./product/js/saleProductList.js',function(saleProductList){
	saleProductList.init($('#saleProductList_div'));
});
</script>