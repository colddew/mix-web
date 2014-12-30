package edu.ustc.mix.persistence.mapper.permission;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.permission.User;

public interface UserMapper {
	
	int add(User user);
	
	int delete(Long userId);
	
	int update(User user);
	
	User getById(Long userId);
	
	User getUserAndRelatedInfo(Long userId);
	
	User getByMultiParams(Map<String, Object> params);
	
	List<User> list(Map<String, Object> params);
	
	List<User> getAllUsersAndRelatedInfo(Map<String, Object> params);
	
	long count(Map<String, Object> params);
}