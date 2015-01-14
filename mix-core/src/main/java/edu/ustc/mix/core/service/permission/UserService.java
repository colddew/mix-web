package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.core.dto.UserDto;
import edu.ustc.mix.persistence.entity.permission.User;

public interface UserService {
	
	public List<User> getAllUsersAndRelatedInfo() throws Exception;
	
	public User getUserById(Long userId) throws Exception;
	
	public User getUserByUserName(String userName) throws Exception;
	
	public User getUserAndRelatedInfo(Long userId) throws Exception;
	
	public User getUserAndRelatedInfo(String userName) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void updateUserAndRelatedRoles(UserDto userDto) throws Exception;
	
	public void add(User user) throws Exception;
	
	public void createUserAndRelatedRoles(UserDto userDto) throws Exception;
	
	public void changePassword(Long userId, String password) throws Exception;
	
	public Set<String> findRoles(String userName) throws Exception;
	
	public Set<String> findPermissions(String userName) throws Exception;
}
