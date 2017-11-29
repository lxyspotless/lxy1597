package com.loan.pms.product.dto;

public class DatagridBaseDTO {

	/*页号*/
	private String page;
	/*每页行数*/
	private String rows;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	
}
