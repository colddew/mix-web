package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.dto.RoleDto;
import edu.ustc.mix.persistence.entity.permission.Role;
import edu.ustc.mix.persistence.entity.permission.RoleResource;
import edu.ustc.mix.persistence.mapper.permission.RoleMapper;
import edu.ustc.mix.persistence.mapper.permission.RoleResourceMapper;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	
	@Override
	public Role getRoleAndRelatedResources(Long roleId) throws Exception {
		
		return roleMapper.getRoleAndRelatedResources(roleId);
	}
	
	@Override
	public void update(Role role) throws Exception {
		
		roleMapper.update(role);
	}
	
	@Override
	public void updateRoleAndRelatedResources(RoleDto roleDto) throws Exception {
		
		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		update(role);
		
		deleteResources(roleDto.getRoleId());
		addResources(roleDto.getRoleId(), roleDto.getResourceIds());
	}
	
	@Override
	public void add(Role role) throws Exception {
		
		roleMapper.add(role);
	}
	
	@Override
	public void createRoleAndRelatedResources(RoleDto roleDto) throws Exception {
		
		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		add(role);
		
		addResources(role.getRoleId(), roleDto.getResourceIds());
	}
	
	private void deleteResources(Long roleId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		
		roleResourceMapper.delete(params);
	}
	
	private void addResources(Long roleId, String resourceIds) throws Exception {
		
		if(null != resourceIds && !"".equals(resourceIds)) {
			
			String[] resIds = resourceIds.split(",");
			for(String resId : resIds) {
				
				RoleResource roleResource = new RoleResource();
				roleResource.setRoleId(roleId);
				roleResource.setResId(Long.valueOf(resId));
				
				roleResourceMapper.add(roleResource);
			}
		}
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
