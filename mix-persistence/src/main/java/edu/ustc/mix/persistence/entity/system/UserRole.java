package edu.ustc.mix.persistence.entity.system;

public class UserRole {
    
	private Long refId;
    private Long userId;
    private Long roleId;
    
    public Long getRefId() {
        return refId;
    }
    
    public void setRefId(Long refId) {
        this.refId = refId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}