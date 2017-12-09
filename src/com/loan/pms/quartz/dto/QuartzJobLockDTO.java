package com.loan.pms.quartz.dto;

import java.sql.Timestamp;

public class QuartzJobLockDTO {

	// 业务主体
	private String businessType;
	// 锁目标ID
	private String targetId;
	// 锁类型
	private String targetType;
	// 锁定时间
	private Timestamp lockedDate;
	// 失效时间
	private Timestamp expiredDate;
	// 是否有效
	private String isEffective;
	
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public Timestamp getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Timestamp lockedDate) {
		this.lockedDate = lockedDate;
	}
	public Timestamp getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	
}
