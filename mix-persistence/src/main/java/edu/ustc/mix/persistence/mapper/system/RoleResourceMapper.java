package edu.ustc.mix.persistence.mapper.system;

import java.util.Map;

import edu.ustc.mix.persistence.entity.system.RoleResource;

public interface RoleResourceMapper {
	
	int add(RoleResource roleResource);
    
	int delete(Map<String, Object> params);
}