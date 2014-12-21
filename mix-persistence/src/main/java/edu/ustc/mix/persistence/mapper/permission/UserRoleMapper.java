package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.Role;
import edu.ustc.mix.persistence.entity.permission.User;

public interface UserRoleMapper {
	
	int add(User user, Role role);
	
	int delete(Map<String, Object> params);
}