package edu.ustc.mix.front.action.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		model.addAttribute("allRoles", roleService.getAllRoles());
		
		return "/role";
	}
	
	@RequestMapping("/{roldId}/edit")
	public String edit(Long roleId, Model model) throws Exception {
		
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/role-edit";
	}
}
