package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.dto.ResourceDto;
import edu.ustc.mix.core.util.MixConstants;
import edu.ustc.mix.persistence.entity.permission.Resource;
import edu.ustc.mix.persistence.mapper.permission.ResourceMapper;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> getAllResources() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return resourceMapper.list(params);
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
	public Set<String> findPermissions(Long... resIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Resource> findMenus(Set<String> permissions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
