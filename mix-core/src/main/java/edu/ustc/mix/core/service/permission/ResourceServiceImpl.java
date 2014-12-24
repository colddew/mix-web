package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
