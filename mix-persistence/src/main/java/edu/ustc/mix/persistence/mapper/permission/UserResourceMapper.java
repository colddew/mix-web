package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.Resource;
import edu.ustc.mix.persistence.entity.permission.User;

public interface UserResourceMapper {
	
	int add(User user, Resource resource);
	
	int delete(Map<String, Object> params);
}