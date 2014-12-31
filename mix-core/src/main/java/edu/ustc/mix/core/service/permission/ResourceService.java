package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.core.dto.ResourceDto;
import edu.ustc.mix.persistence.entity.permission.Resource;

public interface ResourceService {
	
	void add(Resource resource) throws Exception;
	
	public void createResource(ResourceDto resourceDto) throws Exception;
	
	public Resource getResource(Long resId) throws Exception;
	
	void update(Resource resource) throws Exception;
	
	public void updateResource(ResourceDto resourceDto) throws Exception;
	
	public List<Resource> getAllResources() throws Exception;
	
	public Set<String> findPermissions(Long... resIds) throws Exception;
	
	public List<Resource> findMenus(Set<String> permissions) throws Exception;
}
