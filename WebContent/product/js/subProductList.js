define(function(require, exports, module){
	//datagrid引用
	var $dg;
	
	exports.init = function(tb){
		tb.find('#subProductSearchPanel').panel({
			title:'查询条件',
			collapsible:true
		});
		
		// 业务条线
		tb.find('#subProductList_businessLine').combobox({
			url : './queryDictionaryCodeItem.json?codeNo=BusinessLine',
			method : 'get',
			valueField: 'itemNo',
			textField: 'itemName',
			editable: false,
			panelHeight: 'auto'
		});
		
		// 销售产品名称
		tb.find('#subProductList_saleProductNo').combobox({
			url : './queryAllSaleProductList.json',
			method : 'get',
			valueField: 'productNo',
			textField: 'productName',
			editable: false,
			panelHeight: 'auto'
		});

		// 是否有效
		tb.find('#subProductList_status').combobox({
			valueField: 'value',
			textField: 'text',
			data: [{
				value: 'PUBLISHED',
				text: '生效'
			},{
				value: 'NEW',
				text: '未生效'
			}],
			editable: false,
			panelHeight: 'auto'
		});
		
		// 默认有效
		$('#subProductList_status').combobox('select', 'PUBLISHED');
		
		$dg = tb.find('#subProductListDataTable').datagrid({
			url: './querySubProductList.json',
			singleSelect: true, //只允许选择一行
			fitColumns: false,	//自动展开
			striped: true,		//斑马线效果
			pagination: true,	//显示分页工具
			rownumbers: true,	//显示行数
			checkOnSelect: false,//
			columns: [
			    [{
			    	field: 'parentProductNo',
			    	title: '上级产品编号',
			    	hidden:'true'
			    },{
			    	field: 'parentProductName',
			    	title: '销售产品名称',
			    	width: '150'
			    },{
			    	field: 'productNo',
			    	title: '产品编号',
			    	width: '150'
			    },{
			    	field: 'versionNo',
			    	title: '版本号',
			    	width: '100'
			    },{
			    	field: 'productName',
			    	title: '产品名称',
			    	width: '150'
			    },{
			    	field: 'effectiveDate',
			    	title: '生效日期',
			    	width: '150'
			    },{
			    	field: 'status',
			    	title: '产品状态',
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
		    	saleProductNo:'',
		    	productNo:'',
		    	productName:'',
		    	status:'PUBLISH'
		    },
		    loadFilter: details,
		    toolbar:[{
			    	iconCls: 'icon-search',
			    	text: '查询',
			    	handler: querySubProductList
			    },{
			    	iconCls: 'icon-clear',
			    	text: '清空',
			    	handler: clearSubProductInput
			    },
		    ]
		});
	};
	
	function details(data){
		return data;
	}
	
	function querySubProductList(){
		var businessLine = $('#subProductList_businessLine').combobox('getValue')==undefined?'':$('#subProductList_businessLine').combobox('getValue');
		var saleProductNo = $.trim($('#subProductList_saleProductNo').val());
		var productNo = $.trim($('#subProductList_productNo').val());
		var productName = $.trim($('#subProductList_productName').val());
		var status = $('#subProductList_status').combobox('getValue')==undefined?'':$('#subProductList_status').combobox('getValue');
		$dg.datagrid({
			url:'./querySubProductList.json',
			queryParams:{
		    	businessLine:businessLine,
		    	saleProductNo:saleProductNo,
		    	productNo:productNo,
		    	productName:productName,
		    	status:status
		    }
		});
	}

	function clearSubProductInput(){
		$('#subProductList_businessLine').combobox('clear');
		$('#subProductList_saleProductNo').val('');
		$('#subProductList_productNo').val('');
		$('#subProductList_productName').val('');
		$('#subProductList_status').combobox('clear');
	}
})