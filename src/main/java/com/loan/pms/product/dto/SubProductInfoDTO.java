package com.loan.pms.product.dto;

public class SubProductInfoDTO {

	/*上级产品编号*/
	private String parentProductNo;
	/*上级产品名称*/
	private String parentProductName;
	/*产品编号*/
	private String productNo;
	/*版本号*/
	private String versionNo;
	/*产品名称*/
	private String productName;
	/*生效日期*/
	private String effectiveDate;
	/*产品状态*/
	private String status;
	/*创建人*/
	private String createdBy;
	/*创建时间*/
	private String dateCreated;
	/*更新人*/
	private String updatedBy;
	/*更新时间*/
	private String dateUpdated;
	
	public String getParentProductNo() {
		return parentProductNo;
	}
	public void setParentProductNo(String parentProductNo) {
		this.parentProductNo = parentProductNo;
	}
	public String getParentProductName() {
		return parentProductName;
	}
	public void setParentProductName(String parentProductName) {
		this.parentProductName = parentProductName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
}
