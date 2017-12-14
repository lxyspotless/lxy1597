package com.loan.pms.product.dto;

public class QuerySubProductDTO extends DatagridBaseDTO {
	/*业务条线*/
	private String businessLine;
	/*销售产品编号*/
	private String saleProductNo;
	/*产品编号*/
	private String productNo;
	/*产品名称*/
	private String productName;
	/*状态*/
	private String status;
	
	public String getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
	public String getSaleProductNo() {
		return saleProductNo;
	}
	public void setSaleProductNo(String saleProductNo) {
		this.saleProductNo = saleProductNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
