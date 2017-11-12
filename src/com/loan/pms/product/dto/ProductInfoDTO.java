package com.loan.pms.product.dto;

public class ProductInfoDTO {

	/*id*/
	private String id;
	/*业务主体*/
	private String businessOwner;
	/*业务条线*/
	private String businessLine;
	/*产品类型*/
	private String productType;
	/*产品编号*/
	private String productNo;
	/*产品名称*/
	private String productName;
	/*上级产品编码*/
	private String parentProductNo;
	/*部门编码*/
	private String deptCode;
	/*备注*/
	private String remark;
	/*创建人*/
	private String createdBy;
	/*创建时间*/
	private String dateCreated;
	/*更新人*/
	private String updatedBy;
	/*更新时间*/
	private String dateUpdated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusinessOwner() {
		return businessOwner;
	}
	public void setBusinessOwner(String businessOwner) {
		this.businessOwner = businessOwner;
	}
	public String getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
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
	public String getParentProductNo() {
		return parentProductNo;
	}
	public void setParentProductNo(String parentProductNo) {
		this.parentProductNo = parentProductNo;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
