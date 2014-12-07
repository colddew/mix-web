package edu.ustc.mix.persistence.mapper;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.Admin;

public interface AdminMapper {
	
	List<Admin> list(Map<String, Object> params);
	
	Admin selectByUsername(String username);
	
	int deleteByPrimaryKey(Long adminId);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Long adminId);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
}