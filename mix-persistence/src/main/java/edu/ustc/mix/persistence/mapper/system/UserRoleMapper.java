package edu.ustc.mix.persistence.mapper.system;

import java.util.Map;

import edu.ustc.mix.persistence.entity.system.UserRole;

public interface UserRoleMapper {
	
	int add(UserRole userRole);
	
	int delete(Map<String, Object> params);
}