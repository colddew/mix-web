package edu.ustc.mix.security.service;

import java.util.Map;

public interface SecurityService {
	
	public Map<String, Object> login(String username, String password) throws Exception;
	
	public void logout() throws Exception;
}
