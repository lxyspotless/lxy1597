package com.loan.pms.common.dto;

public class DataDictionaryDTO {

	/*数据字典类型*/
	private String codeNo;
	/*数据字典类型名称*/
	private String codeName;
	/*数据字典编码*/
	private String itemNo;
	/*数据字典编码名称*/
	private String itemName;
	/*序号*/
	private String sortNo;
	
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSortNo() {
		return sortNo;
	}
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
}
