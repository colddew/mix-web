package edu.ustc.mix.persistence.entity.system;

public class Organization {
	
	private Long orgId;
	private String orgName;
	private String orgDesc;
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