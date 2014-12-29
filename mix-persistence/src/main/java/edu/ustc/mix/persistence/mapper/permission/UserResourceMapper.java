package edu.ustc.mix.persistence.mapper.permission;

import java.util.Map;

public interface UserResourceMapper {
	
	int add(Long userId, Long resId);
	
	int delete(Map<String, Object> params);
}