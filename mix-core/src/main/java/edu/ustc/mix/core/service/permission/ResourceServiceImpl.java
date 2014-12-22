package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.permission.Resource;

@Service
public class ResourceServiceImpl implements ResourceService {
	
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
