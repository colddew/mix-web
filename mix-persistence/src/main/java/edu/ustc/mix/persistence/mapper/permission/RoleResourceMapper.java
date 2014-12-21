package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.Resource;
import edu.ustc.mix.persistence.entity.permission.Role;

public interface RoleResourceMapper {
	
	int add(Role role, Resource resource);
    
	int delete(Map<String, Object> params);
}