package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.core.dto.RoleDto;
import edu.ustc.mix.persistence.entity.permission.Role;

public interface RoleService {
	
	public Role getRoleAndRelatedResources(Long roleId) throws Exception;
	
	public void update(Role role) throws Exception;
	
	public void updateRoleAndRelatedResources(RoleDto roleDto) throws Exception;
	
	public List<Role> getAllRolesAndRelatedResources() throws Exception;
	
	public Set<String> findRoles(Long... roleIds) throws Exception;
	
	public Set<String> findPermissions(Long... roleIds) throws Exception;
}
