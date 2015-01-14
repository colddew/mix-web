package edu.ustc.mix.persistence.mapper.system;

import java.util.Map;

public interface UserResourceMapper {
	
	int add(Long userId, Long resId);
	
	int delete(Map<String, Object> params);
}