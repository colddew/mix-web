package edu.ustc.mix.persistence.mapper.permission;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.Resource;

public interface ResourceMapper {
    
	int add(Resource resource);
	
	int delete(Long resId);
	
	int update(Resource resource);
	
	Resource getById(Long resId);
	
	Resource getByMultiParams(Map<String, Object> params);
	
	List<Resource> list(Map<String, Object> params);
	
	long count(Map<String, Object> params);
}