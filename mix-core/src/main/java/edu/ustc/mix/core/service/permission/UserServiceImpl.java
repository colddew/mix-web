package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.permission.User;
import edu.ustc.mix.persistence.mapper.permission.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUsers() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return userMapper.listUsersAndRelatedRoles(params);
	}
	
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
