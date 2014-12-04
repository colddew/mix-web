package edu.ustc.mix.persistence.entity;

import java.math.BigDecimal;

public class Admin {
	
	private Long adminId;
	private String userName;
	private String adminPassword;
	private String realName;
	private String adminEmail;
	private String mobilePhone;
	private BigDecimal adminType;
	private BigDecimal adminStatus;
	private Long orgId;
	
	public Long getAdminId() {
		return adminId;
	}
	
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword == null ? null : adminPassword
				.trim();
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}
	
	public String getAdminEmail() {
		return adminEmail;
	}
	
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail == null ? null : adminEmail.trim();
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
	}
	
	public BigDecimal getAdminType() {
		return adminType;
	}
	
	public void setAdminType(BigDecimal adminType) {
		this.adminType = adminType;
	}
	
	public BigDecimal getAdminStatus() {
		return adminStatus;
	}
	
	public void setAdminStatus(BigDecimal adminStatus) {
		this.adminStatus = adminStatus;
	}
	
	public Long getOrgId() {
		return orgId;
	}
	
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}