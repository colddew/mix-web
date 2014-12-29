package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

public interface RoleResourceMapper {
	
	int add(Long roleId, Long resourceId);
    
	int delete(Map<String, Object> params);
}