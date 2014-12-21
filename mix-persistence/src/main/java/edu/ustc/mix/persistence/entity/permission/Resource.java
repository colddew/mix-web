package edu.ustc.mix.persistence.entity.permission;

public class Resource {
    
	private Long resId;
    private String resName;
    private String resDesc;
    private String permission;
    private Integer resType;
    private Integer resLevel;
    private Long parentId;
    private Integer priority;
    
    public Long getResId() {
        return resId;
    }
    
    public void setResId(Long resId) {
        this.resId = resId;
    }
    
    public String getResName() {
        return resName;
    }
    
    public void setResName(String resName) {
        this.resName = resName;
    }
    
    public String getResDesc() {
        return resDesc;
    }
    
    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }
    
    public String getPermission() {
        return permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    public Integer getResType() {
        return resType;
    }
    
    public void setResType(Integer resType) {
        this.resType = resType;
    }
    
    public Integer getResLevel() {
        return resLevel;
    }
    
    public void setResLevel(Integer resLevel) {
        this.resLevel = resLevel;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public Integer getPriority() {
        return priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}