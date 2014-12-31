package edu.ustc.mix.core.dto;

public class ResourceDto {
	
	private Long resId;
	private String resName;
	private String resDesc;
	private String url;
	private String permission;
	private Integer resType;
	private Integer isLeaf;
    private Long parentId;
    private String parentPath;
	
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
	
	public Integer getIsLeaf() {
		return isLeaf;
	}
	
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public String getParentPath() {
		return parentPath;
	}
	
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}
}
