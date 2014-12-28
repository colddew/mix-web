package edu.ustc.mix.core.service.permission;

import java.util.List;
import java.util.Set;

import edu.ustc.mix.persistence.entity.permission.User;

public interface UserService {
	
	public List<User> getAllUsers() throws Exception;
	
	public User findUserByUserName(String userName) throws Exception;
	
	public void changePassword(Long userId, String password) throws Exception;
	
	public Set<String> findRoles(String userName) throws Exception;
	
	public Set<String> findPermissions(String userName) throws Exception;
}
