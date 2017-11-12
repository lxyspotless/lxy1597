define(function(require, exports, module){
	//datagride引用
	var $dg;
	
	exports.init = function(tb){
		tb.find('#saleProductSearchPanel').panel({
			title:'查询条件',
			collapsible:true
		});
		
		tb.find('#saleProductList_businessLine').combobox({
			valueField: 'value',
			textField: 'text',
			editable: false,
			panelHeight: 'auto',
			data: [{
				value: '10001',
				text: '无抵押'
			},{
				value: '10002',
				text: '有抵押'
			}]
		});
		
		$dg = tb.find('#saleProductListDataTable').datagrid({
			url: './querySaleProductList.do',
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
			    }
			    ]
			        ],
			    queryParam:{
			    	businessLine:'',
			    	saleProductName:''
			    },
			    loadFilter: details/*,
			    toolbar:[{
			    	iconCls: 'icon-search',
			    	text: '查询',
			    	handler: querySaleProductList
			    }]*/
		});
	};
	
	function details(data){
		return data;
	}
	
})