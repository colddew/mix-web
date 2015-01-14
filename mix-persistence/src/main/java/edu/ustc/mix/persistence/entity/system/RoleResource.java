package edu.ustc.mix.persistence.entity.system;

public class RoleResource {
    
	private Long refId;
    private Long roleId;
    private Long resId;
    
    public Long getRefId() {
        return refId;
    }
    
    public void setRefId(Long refId) {
        this.refId = refId;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public Long getResId() {
        return resId;
    }
    
    public void setResId(Long resId) {
        this.resId = resId;
    }
}