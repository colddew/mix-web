package edu.ustc.mix.persistence.mapper;

import edu.ustc.mix.persistence.entity.Admin;

public interface AdminMapper {
	
	int deleteByPrimaryKey(Long adminId);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Long adminId);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
}