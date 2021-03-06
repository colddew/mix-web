package edu.ustc.mix.core.service.system;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.dto.RoleDto;
import edu.ustc.mix.core.util.CollectionUtils;
import edu.ustc.mix.persistence.entity.system.Resource;
import edu.ustc.mix.persistence.entity.system.Role;
import edu.ustc.mix.persistence.entity.system.RoleResource;
import edu.ustc.mix.persistence.mapper.system.RoleMapper;
import edu.ustc.mix.persistence.mapper.system.RoleResourceMapper;
import edu.ustc.mix.persistence.mapper.system.UserRoleMapper;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	public List<Role> getAllRoles() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return roleMapper.list(params);
	}
	
	@Override
	public List<Role> getAllRolesAndRelatedResources() throws Exception {
		
		return roleMapper.getAllRolesAndRelatedResources();
	}
	
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
		
		deleteRelatedResourcesByRoleId(roleDto.getRoleId());
		addRelatedResources(roleDto.getRoleId(), roleDto.getResourceIds());
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
		
		addRelatedResources(role.getRoleId(), roleDto.getResourceIds());
	}
	
	private void deleteRelatedResourcesByRoleId(Long roleId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		
		roleResourceMapper.delete(params);
	}
	
	private void addRelatedResources(Long roleId, String resourceIds) throws Exception {
		
		if(null != roleId && StringUtils.isNotBlank(resourceIds)) {
			
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
	public Set<String> findPermissions(Set<Long> roleIds) throws Exception {
		
		Set<String> set = new HashSet<String>();
		
		if(CollectionUtils.isNotEmpty(roleIds)) {
			
			for(Long roleId : roleIds) {
				
				Role role = getRoleAndRelatedResources(roleId);
				List<Resource> resources = role.getResources();
				
				for(Resource resource : resources) {
					
					if(CollectionUtils.isNotEmpty(resources) && StringUtils.isNotBlank(resource.getPermission())) {
						set.add(resource.getPermission());
					}
				}
			}
		}
		
		return set;
	}
	
	@Override
	public void delete(Long roleId) throws Exception {
		
		roleMapper.delete(roleId);
	}
	
	@Override
	public void deleteRoleAndRelatedUsersAndResources(Long roleId) throws Exception {
		
		deleteRelatedResourcesByRoleId(roleId);
		
		deleteRelatedUsersByRoleId(roleId);
		
		delete(roleId);
	}
	
	private void deleteRelatedUsersByRoleId(Long roleId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		
		userRoleMapper.delete(params);
	}
}
