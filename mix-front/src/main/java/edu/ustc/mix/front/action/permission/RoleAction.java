package edu.ustc.mix.front.action.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.permission.ResourceService;
import edu.ustc.mix.core.service.permission.RoleService;

@Controller
@Scope("prototype")
@RequestMapping(value = "/role")
public class RoleAction {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		model.addAttribute("allRoles", roleService.getAllRolesAndRelatedResources());
		
		return "/role";
	}
	
	@RequestMapping(value = "/{roleId}/edit")
	public String edit(@PathVariable Long roleId, Model model) throws Exception {
		
		validateRoleId(roleId);
		
		model.addAttribute("role", roleService.getRoleAndRelatedResources(roleId));
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/role-edit";
	}
	
	private void validateRoleId(Long roleId) throws Exception {
		if(null == roleId) {
			throw new Exception("roleId is null");
		}
	}
}
