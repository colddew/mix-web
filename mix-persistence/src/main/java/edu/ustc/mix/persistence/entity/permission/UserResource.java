package edu.ustc.mix.persistence.entity.permission;

public class UserResource {
    
	private Long refId;
    private Long userId;
    private Long resId;
    
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
    
    public Long getResId() {
        return resId;
    }
    
    public void setResId(Long resId) {
        this.resId = resId;
    }
}