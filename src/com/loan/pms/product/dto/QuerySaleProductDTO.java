package com.loan.pms.product.dto;

public class QuerySaleProductDTO extends DatagridBaseDTO {
	/*业务条线*/
	private String businessLine;
	/*销售产品名称*/
	private String productName;
	/*产品类型*/
	private String productType;
	
	public String getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
