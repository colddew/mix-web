package edu.ustc.mix.core.service.permission;

import java.util.Set;

public interface RoleService {
	
	public Set<String> findRoles(Long... roleIds) throws Exception;
	
	public Set<String> findPermissions(Long... roleIds) throws Exception;
}
