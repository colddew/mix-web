package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.dto.UserDto;
import edu.ustc.mix.core.util.CollectionUtils;
import edu.ustc.mix.core.util.PasswordUtils;
import edu.ustc.mix.persistence.entity.permission.Role;
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
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public List<User> getAllUsersAndRelatedInfo() throws Exception {
		
		return userMapper.getAllUsersAndRelatedInfo();
	}
	
	@Override
	public User getUserById(Long userId) throws Exception {
		
		return userMapper.getById(userId);
	}
	
	@Override
	public User getUserByUserName(String userName) throws Exception {
		
		return userMapper.getByUserName(userName);
	}
	
	@Override
	public User getUserAndRelatedInfo(Long userId) throws Exception {
		
		return userMapper.getUserAndRelatedInfoById(userId);
	}
	
	@Override
	public User getUserAndRelatedInfo(String userName) throws Exception {
		
		return userMapper.getUserAndRelatedInfoByUserName(userName);
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
		
		if(null != userId && StringUtils.isNotBlank(roleIds)) {
			
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
	public void changePassword(Long userId, String password) throws Exception {
		
		User user = getUserById(userId);
		user.setPassword(password);
		passwordUtils.encryptPassword(user);
		update(user);
	}
	
	@Override
	public Set<String> findRoles(String userName) throws Exception {
		
		Set<String> set = new HashSet<String>();
		
		User user = getUserAndRelatedInfo(userName);
		
		List<Role> roles = user.getRoles();
		if(CollectionUtils.isNotEmpty(roles)) {
			
			for(Role role : roles) {
				
				if(StringUtils.isNoneBlank(role.getRoleName())) {
					set.add(role.getRoleName());
				}
			}
		}
		
		return set;
	}
	
	@Override
	public Set<String> findPermissions(String userName) throws Exception {
		
		Set<Long> roleIds = findRoleIds(userName);
		
		return roleService.findPermissions(roleIds);
	}
	
	private Set<Long> findRoleIds(String userName) throws Exception {
		
		Set<Long> set = new HashSet<Long>();
		
		User user = getUserAndRelatedInfo(userName);
		
		List<Role> roles = user.getRoles();
		if(CollectionUtils.isNotEmpty(roles)) {
			
			for(Role role : roles) {
				
				set.add(role.getRoleId());
			}
		}
		
		return set;
	}
}
