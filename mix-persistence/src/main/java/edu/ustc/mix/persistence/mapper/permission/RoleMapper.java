package edu.ustc.mix.persistence.mapper.permission;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.Role;

public interface RoleMapper {
	
	int add(Role role);
	
	int delete(Long roleId);
	
	int update(Role role);
	
	Role getById(Long roleId);
	
	Role getRoleAndRelatedResources(Long roleId);
	
	Role getByMultiParams(Map<String, Object> params);
	
	List<Role> list(Map<String, Object> params);
	
	List<Role> getAllRolesAndRelatedResources(Map<String, Object> params);
	
	long count(Map<String, Object> params);
}