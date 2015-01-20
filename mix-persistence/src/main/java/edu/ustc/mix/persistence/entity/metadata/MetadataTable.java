package edu.ustc.mix.persistence.entity.metadata;

public class MetadataTable {
	
	private Integer tableId;
	private String tableName;
	private String tableDesc;
	private Integer tableType;
	private String operator;
	
	public Integer getTableId() {
		return tableId;
	}
	
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableDesc() {
		return tableDesc;
	}
	
	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}
	
	public Integer getTableType() {
		return tableType;
	}
	
	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
}