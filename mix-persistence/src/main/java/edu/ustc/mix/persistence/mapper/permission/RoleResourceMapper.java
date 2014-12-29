package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.RoleResource;

public interface RoleResourceMapper {
	
	int add(RoleResource roleResource);
    
	int delete(Map<String, Object> params);
}