package edu.ustc.mix.core.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.dto.ResourceDto;
import edu.ustc.mix.core.util.CollectionUtils;
import edu.ustc.mix.core.util.MixConstants;
import edu.ustc.mix.persistence.entity.system.Resource;
import edu.ustc.mix.persistence.mapper.system.ResourceMapper;
import edu.ustc.mix.persistence.mapper.system.RoleResourceMapper;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	
	@Override
	public List<Resource> getAllResources() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return resourceMapper.list(params);
	}
	
	public List<Resource> findResourcesByParams(Map<String, Object> params) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(params);
		
		return resourceMapper.list(map);
	}
	
	@Override
	public void add(Resource resource) throws Exception {
		
		resourceMapper.add(resource);
	}
	
	@Override
	public void createResource(ResourceDto resourceDto) throws Exception {
		
		Resource parent = getResource(resourceDto.getParentId());
		parent.setIsLeaf(MixConstants.IS_LEAF_NO);
		update(parent);
		
		Resource resource = new Resource();
		BeanUtils.copyProperties(resourceDto, resource);
		resource.setIsLeaf(MixConstants.IS_LEAF_YES);
		resource.setParentPath(parent.getParentPath() + parent.getResId() + "/");
		add(resource);
	}
	
	@Override
	public Resource getResource(Long resId) throws Exception {
		
		return resourceMapper.getById(resId);
	}
	
	@Override
	public void update(Resource resource) throws Exception {
		
		resourceMapper.update(resource);
	}
	
	@Override
	public void updateResource(ResourceDto resourceDto) throws Exception {
		
		Resource resource = new Resource();
		BeanUtils.copyProperties(resourceDto, resource, new String[] {"isLeaf", "parentId", "parentPath"});
		update(resource);
	}
	
	@Override
	public List<Resource> findSystemManagementMenus(Set<String> userPermissions) throws Exception {
		
		List<Resource> systemManagementMenus = new ArrayList<Resource>();
		
		List<Resource> allResources = getAllResources();
		if(CollectionUtils.isNotEmpty(allResources)) {
			
			for(Resource resource : allResources) {
				
				if(null != resource && isSystemManagementMenu(resource) && hasPermission(userPermissions, resource.getPermission())) {
					
					systemManagementMenus.add(resource);
				}
			}
		}
		
		return systemManagementMenus;
	}

	private boolean isSystemManagementMenu(Resource resource) throws Exception {
		
		return MixConstants.RES_TYPE_URL.equals(resource.getResType());
	}
	
	private boolean hasPermission(Set<String> userPermissions, String systemPermission) throws Exception {
		
		if(StringUtils.isBlank(systemPermission)) {
			return true;
		}
		
		if(CollectionUtils.isNotEmpty(userPermissions)) {
			
			WildcardPermission swp = new WildcardPermission(systemPermission);
			
			for(String permission : userPermissions) {
				
				if(StringUtils.isNotBlank(permission)) {
					
					WildcardPermission uwp = new WildcardPermission(permission);
					
					if(uwp.implies(swp) || swp.implies(uwp)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void delete(Long resId) throws Exception {
		
		resourceMapper.delete(resId);
	}
	
	@Override
	public void deleteResourceAndRelatedRoles(Long resId) throws Exception {
		
		deleteChildrenResourceAndRelatedRoles(resId);
		
		deleteRelatedRolesByResId(resId);
		
		delete(resId);
	}

	private void deleteChildrenResourceAndRelatedRoles(Long resId) throws Exception {
		
		List<Resource> children = findChildren(resId);
		if(hasChildren(children)) {
			
			for(Resource child : children) {
				
				if(null != child && null != child.getResId()) {
					
					deleteResourceAndRelatedRoles(child.getResId());
				}
			}
		}
	}
	
	private void deleteRelatedRolesByResId(Long resId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("resId", resId);
		
		roleResourceMapper.delete(params);
	}
	
	private List<Resource> findChildren(Long resId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", resId);
		
		return findResourcesByParams(params);
	}
	
	private boolean hasChildren(List<Resource> children) throws Exception {
		
		return CollectionUtils.isNotEmpty(children);
	}
}
