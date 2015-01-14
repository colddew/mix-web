package edu.ustc.mix.front.security;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ustc.mix.core.service.system.ResourceService;
import edu.ustc.mix.core.service.system.UserService;
import edu.ustc.mix.core.util.MixConstants;
import edu.ustc.mix.persistence.entity.system.Resource;

public class SystemUserFilter extends PathMatchingFilter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, 
			Object mappedValue) throws Exception {
		
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		request.setAttribute(MixConstants.CURRENT_USER, userService.getUserByUserName(userName));
		
		Set<String> permissions = userService.findPermissions(userName);
		List<Resource> systemManagementMenus = resourceService.findSystemManagementMenus(permissions);
		request.setAttribute("systemManagementMenus", systemManagementMenus);
		
		return true;
	}
}
