package edu.ustc.mix.persistence.mapper.system;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.system.User;

public interface UserMapper {
	
	int add(User user);
	
	int delete(Long userId);
	
	int update(User user);
	
	User getById(Long userId);
	
	User getByUserName(String userName);
	
	User getUserAndRelatedInfoById(Long userId);
	
	User getUserAndRelatedInfoByUserName(String userName);
	
	User getByMultiParams(Map<String, Object> params);
	
	List<User> list(Map<String, Object> params);
	
	List<User> getAllUsersAndRelatedInfo();
	
	long count(Map<String, Object> params);
}