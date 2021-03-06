package edu.ustc.mix.core.service.system;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.core.dto.RoleDto;
import edu.ustc.mix.persistence.entity.system.Role;

public interface RoleService {
	
	public List<Role> getAllRoles() throws Exception;
	
	public Role getRoleAndRelatedResources(Long roleId) throws Exception;
	
	public void update(Role role) throws Exception;
	
	public void updateRoleAndRelatedResources(RoleDto roleDto) throws Exception;
	
	public void add(Role role) throws Exception;
	
	public void createRoleAndRelatedResources(RoleDto roleDto) throws Exception;
	
	public List<Role> getAllRolesAndRelatedResources() throws Exception;
	
    public Set<String> findPermissions(Set<Long> roleIds) throws Exception;
    
    public void delete(Long roleId) throws Exception;
	
	public void deleteRoleAndRelatedUsersAndResources(Long roleId) throws Exception;
}
