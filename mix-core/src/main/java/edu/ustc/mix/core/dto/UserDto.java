package edu.ustc.mix.core.dto;

public class UserDto {
	
	private Long userId;
	private String userName;
	private String salt;
	private String password;
	private Integer userType;
	private Integer userStatus;
	private Long orgId;
	
	private String roleIds;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Integer getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	public Long getOrgId() {
		return orgId;
	}
	
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	public String getRoleIds() {
		return roleIds;
	}
	
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
}
