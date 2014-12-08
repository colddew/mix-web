package edu.ustc.mix.security.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MixRealm extends AuthorizingRealm {
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.fromRealm(getName()).iterator().next();
		if (null != username) {
			
//			User user = accountManager.findUserByUserName(userName);
//			if (null != user && null != user.getRoles()) {
//				
//				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//				for (SecurityRole each : user.getRoles()) {
//					info.addRole(each.getName());
//					info.addStringPermissions(each.getPermissionsAsString());
//				}
//				
//				return info;
//			}
		}
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
//		UsernamePasswordToken upt = (UsernamePasswordToken) token;
//		
//		String userName = upt.getUsername();
//			
//		User user = accountManager.findUserByUserName(token.getUsername());
//
//		if (null != user) {
//			return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
//		}
		
		return null;
	}

}
