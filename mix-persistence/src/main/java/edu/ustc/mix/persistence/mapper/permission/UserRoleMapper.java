package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.UserRole;

public interface UserRoleMapper {
	
	int add(UserRole userRole);
	
	int delete(Map<String, Object> params);
}