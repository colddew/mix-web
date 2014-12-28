package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.permission.Role;
import edu.ustc.mix.persistence.mapper.permission.RoleMapper;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Role getRoleAndRelatedResources(Long roleId) throws Exception {
		
		return roleMapper.getRoleAndRelatedResources(roleId);
	}
	
	@Override
	public List<Role> getAllRolesAndRelatedResources() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return roleMapper.getAllRolesAndRelatedResources(params);
	}
	
	@Override
	public Set<String> findRoles(Long... roleIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<String> findPermissions(Long... roleIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
