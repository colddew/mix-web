package edu.ustc.mix.security.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class SecurityServiceImpl implements SecurityService {
	
	public static final String DEFAULT_INI_RESOURCE_PATH = "classpath:shiro.ini";
	
	@Override
	public Map<String, Object> login(String username, String password) throws Exception {
		
		try {
			// collect the subject's principals and credentials
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			
			// submit the principals and credentials
			Subject currentUser = getSubject();
			currentUser.login(token);
			
			// handling success or failure
			return setLoginResult(Boolean.TRUE, "");
		} catch (UnknownAccountException uae) {
			return setLoginResult(Boolean.FALSE, "account is unknown");
		} catch (IncorrectCredentialsException ice) {
			return setLoginResult(Boolean.FALSE, "password is incorrect");
		} catch (LockedAccountException lae) {
			return setLoginResult(Boolean.FALSE, "account is locked?");
		} catch (ExcessiveAttemptsException eae) {
			return setLoginResult(Boolean.FALSE, "attempt times is excessive");
		} catch (AuthenticationException ae) {
			return setLoginResult(Boolean.FALSE, "authentication exception, " + ae.getMessage());
		} catch (Exception e) {
			return setLoginResult(Boolean.FALSE, "unknown exception, " + e.getMessage());
		}
	}
	
	@Override
	public void logout() throws Exception {
		Subject currentUser = getSubject();
		currentUser.logout();
	}
	
	private SecurityManager getSecurityManager() throws Exception {
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(DEFAULT_INI_RESOURCE_PATH);
		
		return factory.getInstance();
	}
	
	private Subject getSubject() throws Exception {
		
		SecurityUtils.setSecurityManager(getSecurityManager());
		
		return SecurityUtils.getSubject();
	}
	
	private Map<String, Object> setLoginResult(Boolean success, String message) throws Exception {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", success);
		result.put("message", message);
		
		return result;
	}
}
