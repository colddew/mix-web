package edu.ustc.mix.core.dto;

public class RoleDto {
	
	private Long roleId;
	private String roleName;
	private String roleDesc;
	private String resourceIds;
	
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleDesc() {
		return roleDesc;
	}
	
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	public String getResourceIds() {
		return resourceIds;
	}
	
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
}
