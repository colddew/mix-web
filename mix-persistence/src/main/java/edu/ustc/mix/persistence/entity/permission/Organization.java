package edu.ustc.mix.persistence.entity.permission;

public class Organization {
	
	private Long orgId;
	private String orgName;
	private String orgDesc;
	private Integer orgLevel;
	private Long parentId;
	private Integer priority;
	
	public Long getOrgId() {
		return orgId;
	}
	
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	public String getOrgName() {
		return orgName;
	}
	
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getOrgDesc() {
		return orgDesc;
	}
	
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}
	
	public Integer getOrgLevel() {
		return orgLevel;
	}
	
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
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