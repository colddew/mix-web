package edu.ustc.mix.core.service.permission;

import java.util.Set;

import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.permission.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Override
	public User findUserByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void changePassword(Long userId, String password) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Set<String> findRoles(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<String> findPermissions(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
