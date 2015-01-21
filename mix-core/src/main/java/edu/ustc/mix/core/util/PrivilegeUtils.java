package edu.ustc.mix.core.util;

import org.ralasafe.user.User;

public class PrivilegeUtils {
	
	public static User convertMixUserToRalasafeUser(edu.ustc.mix.persistence.entity.system.User user) throws Exception {
		
		User ralasafeUser = new User();
		ralasafeUser.setId(user.getUserId());
		ralasafeUser.set("name", user.getUserName());
		ralasafeUser.set("salt", user.getSalt());
		ralasafeUser.set("password", user.getPassword());
		ralasafeUser.set("userType", user.getUserType());
		ralasafeUser.set("userStatus", user.getUserStatus());
		ralasafeUser.set("orgId", user.getOrgId());
		
		return ralasafeUser;
	}
}
