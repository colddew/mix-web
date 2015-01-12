package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.dto.UserDto;
import edu.ustc.mix.core.util.PasswordUtils;
import edu.ustc.mix.persistence.entity.permission.User;
import edu.ustc.mix.persistence.entity.permission.UserRole;
import edu.ustc.mix.persistence.mapper.permission.UserMapper;
import edu.ustc.mix.persistence.mapper.permission.UserRoleMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private PasswordUtils passwordUtils;
	
	@Override
	public List<User> getAllUsersAndRelatedInfo() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return userMapper.getAllUsersAndRelatedInfo(params);
	}
	
	@Override
	public User getUserAndRelatedInfo(Long userId) throws Exception {
		
		return userMapper.getUserAndRelatedInfo(userId);
	}
	
	@Override
	public void update(User user) throws Exception {
		
		userMapper.update(user);
	}
	
	@Override
	public void updateUserAndRelatedRoles(UserDto userDto) throws Exception {
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user, new String[] {"salt", "password"});
		update(user);
		
		deleteRolesByUserId(userDto.getUserId());
		addRoles(userDto.getUserId(), userDto.getRoleIds());
	}
	
	@Override
	public void add(User user) throws Exception {
		
		userMapper.add(user);
	}
	
	@Override
	public void createUserAndRelatedRoles(UserDto userDto) throws Exception {
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		passwordUtils.encryptPassword(user);
		add(user);
		
		addRoles(user.getUserId(), userDto.getRoleIds());
	}
	
	private void deleteRolesByUserId(Long userId) throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		
		userRoleMapper.delete(params);
	}
	
	private void addRoles(Long userId, String roleIds) throws Exception {
		
		if(null != userId && null != roleIds && !"".equals(roleIds)) {
			
			String[] rids = roleIds.split(",");
			for(String roleId : rids) {
				
				UserRole userRole = new UserRole();
				userRole.setUserId(userId);
				userRole.setRoleId(Long.valueOf(roleId));
				
				userRoleMapper.add(userRole);
			}
		}
	}
	
	@Override
	public User findUserByUserName(String userName) throws Exception {
		
		return userMapper.getByUserName(userName);
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
