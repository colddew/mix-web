package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.persistence.entity.permission.Resource;

public interface ResourceService {
	
	public List<Resource> getAllResources() throws Exception;
	
	public Set<String> findPermissions(Long... resIds) throws Exception;
	
	public List<Resource> findMenus(Set<String> permissions) throws Exception;
}
