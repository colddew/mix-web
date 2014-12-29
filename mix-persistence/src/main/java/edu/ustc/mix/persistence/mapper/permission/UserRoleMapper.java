package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

public interface UserRoleMapper {
	
	int add(Long userId, Long roleId);
	
	int delete(Map<String, Object> params);
}