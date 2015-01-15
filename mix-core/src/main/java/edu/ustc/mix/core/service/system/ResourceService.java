package edu.ustc.mix.core.service.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ustc.mix.core.dto.ResourceDto;
import edu.ustc.mix.persistence.entity.system.Resource;

public interface ResourceService {
	
	void add(Resource resource) throws Exception;
	
	public void createResource(ResourceDto resourceDto) throws Exception;
	
	public Resource getResource(Long resId) throws Exception;
	
	void update(Resource resource) throws Exception;
	
	public void updateResource(ResourceDto resourceDto) throws Exception;
	
	public List<Resource> getAllResources() throws Exception;
	
	public List<Resource> findResourcesByParams(Map<String, Object> params) throws Exception; 
	
	public List<Resource> findSystemManagementMenus(Set<String> permissions) throws Exception;
	
	public void delete(Long resId) throws Exception;
	
	public void deleteResourceAndRelatedRoles(Long resId) throws Exception;
}
