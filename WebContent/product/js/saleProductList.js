define(function(require, exports, module){
	//datagrid引用
	var $dg;
	
	exports.init = function(tb){
		tb.find('#saleProductSearchPanel').panel({
			title:'查询条件',
			collapsible:true
		});
		
		// 业务条线
		tb.find('#saleProductList_businessLine').combobox({
			url : './queryDictionaryCodeItem.json?codeNo=BusinessLine',
			method : 'get',
			valueField: 'itemNo',
			textField: 'itemName',
			editable: false,
			panelHeight: 'auto'
		});
		
		$dg = tb.find('#saleProductListDataTable').datagrid({
			url: './querySaleProductInfoList.json',
			singleSelect: true, //只允许选择一行
			fitColumns: false,	//自动展开
			striped: true,		//斑马线效果
			pagination: true,	//显示分页工具
			rownumbers: true,	//显示行数
			checkOnSelect: false,//
			columns: [
			    [{
			    	field: 'id',
			    	hidden: true
			    },{
			    	field: 'productNo',
			    	title: '销售产品编号',
			    	width: '150'
			    },{
			    	field: 'productName',
			    	title: '销售产品名称',
			    	width: '150'
			    },{
			    	field: 'remark',
			    	title: '销售产品说明',
			    	width: '150'
			    },{
			    	field: 'createdBy',
			    	title: '创建人',
			    	width: '150'
			    },{
			    	field: 'dateCreated',
			    	title: '创建时间',
			    	width: '150'
			    },{
			    	field: 'updatedBy',
			    	title: '更新人',
			    	width: '150'
			    },{
			    	field: 'dateUpdated',
			    	title: '更新时间',
			    	width: '150'
			    }
			    ]
			],
		    queryParam:{
		    	businessLine:'',
		    	saleProductName:''
		    },
		    loadFilter: details,
		    toolbar:[{
			    	iconCls: 'icon-search',
			    	text: '查询',
			    	handler: querySaleProductList
			    },{
			    	iconCls: 'icon-remove',
			    	text: '清空',
			    	handler: clearSaleProductInput
			    },
		    ]
		});
	};
	
	function details(data){
		return data;
	}
	
	function querySaleProductList(){
		var businessLine = $('#saleProductList_businessLine').combobox('getValue')==undefined?'':$('#saleProductList_businessLine').combobox('getValue');
		var saleProductName = $.trim($('#saleProductList_saleProductName').val());
		$dg.datagrid({
			url:'./querySaleProductInfoList.json',
			queryParams:{
		    	businessLine:businessLine,
		    	saleProductName:saleProductName
		    }
		});
	}

	function clearSaleProductInput(){
		$('#saleProductList_businessLine').combobox('clear');
		$('#saleProductList_saleProductName').val('');
	}
})