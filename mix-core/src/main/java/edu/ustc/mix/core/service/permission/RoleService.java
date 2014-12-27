package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.persistence.entity.permission.Role;

public interface RoleService {
	
	public List<Role> getAllRoles() throws Exception;
	
	public Set<String> findRoles(Long... roleIds) throws Exception;
	
	public Set<String> findPermissions(Long... roleIds) throws Exception;
}
