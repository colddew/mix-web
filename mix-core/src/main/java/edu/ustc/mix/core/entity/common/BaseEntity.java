package edu.ustc.mix.core.entity.common;

import java.util.Date;

public class BaseEntity {
	
	@Field
	private String creator;
	
	@Field
	private Date createTime;
	
	@Field
	private String operator;
	
	@Field
	private String updateTime;
	
	@Field
	private Integer isDeleted;
	
	@Field
	private Long order;
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public Integer getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public Long getOrder() {
		return order;
	}
	
	public void setOrder(Long order) {
		this.order = order;
	}
}
