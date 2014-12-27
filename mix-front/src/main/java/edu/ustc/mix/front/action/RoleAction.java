package edu.ustc.mix.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.permission.ResourceService;
import edu.ustc.mix.core.service.permission.RoleService;
import edu.ustc.mix.persistence.entity.permission.Resource;
import edu.ustc.mix.persistence.entity.permission.Role;

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
		
		List<Role> allRoles = roleService.getAllRoles();
		model.addAttribute("allRoles", allRoles);
		
		for(Role role : allRoles) {
			List<Resource> resources = role.getResources();
			for(Resource resource : resources) {
				System.out.println(resource.getResDesc());
			}
		}
		
		return "/role";
	}
	
	@RequestMapping("/edit")
	public String edit(Long roleId, Model model) throws Exception {
		
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/role-edit";
	}
}
