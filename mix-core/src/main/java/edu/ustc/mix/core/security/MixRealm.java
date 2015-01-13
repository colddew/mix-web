package edu.ustc.mix.core.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ustc.mix.core.service.permission.UserService;
import edu.ustc.mix.core.util.MixConstants;
import edu.ustc.mix.persistence.entity.permission.User;

public class MixRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		try {
			String userName = (String) principals.getPrimaryPrincipal();
			
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			authorizationInfo.setRoles(userService.findRoles(userName));
			authorizationInfo.setStringPermissions(userService.findPermissions(userName));
			
			return authorizationInfo;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		try {
			String userName = (String) token.getPrincipal();
			
			User user = userService.getUserByUserName(userName);
			
			if (null == user) {
				throw new UnknownAccountException();
			}
			
			if(MixConstants.USER_STATUS_LOCKED.equals(user.getUserStatus())) {
				throw new LockedAccountException();
			}
			
			return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), 
					ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
		} catch (Exception e) {
			 throw null;
		}
	}
}
