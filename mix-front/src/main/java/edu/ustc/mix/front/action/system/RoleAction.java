package edu.ustc.mix.front.action.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ustc.mix.core.dto.RoleDto;
import edu.ustc.mix.core.service.system.ResourceService;
import edu.ustc.mix.core.service.system.RoleService;
import edu.ustc.mix.persistence.entity.system.Role;

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
		
		return "/system/role";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) throws Exception {
		
		model.addAttribute("role", new Role());
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/system/role-edit";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(RoleDto roleDto, Model model) throws Exception {
		
		roleService.createRoleAndRelatedResources(roleDto);
		
		return "redirect:/role/index.html";
	}
	
	@RequestMapping(value = "/{roleId}/update", method = RequestMethod.GET)
	public String update(@PathVariable Long roleId, Model model) throws Exception {
		
		validateRoleId(roleId);
		
		model.addAttribute("role", roleService.getRoleAndRelatedResources(roleId));
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/system/role-edit";
	}
	
	@RequestMapping(value = "/{roleId}/update", method = RequestMethod.POST)
	public String update(RoleDto roleDto, Model model) throws Exception {
		
		validateRole(roleDto);
		
		roleService.updateRoleAndRelatedResources(roleDto);
		
		return "redirect:/role/index.html";
	}
	
	@RequestMapping(value = "/{roleId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable Long roleId, Model model) throws Exception {
		
		roleService.deleteRoleAndRelatedUsersAndResources(roleId);
		
		return "redirect:/role/index.html";
	}
	
	private void validateRoleId(Long roleId) throws Exception {
		
		if(null == roleId) {
			throw new Exception("roleId is null");
		}
	}
	
	private void validateRole(RoleDto RoleDto) throws Exception {
		
		if(null == RoleDto || null == RoleDto.getRoleId()) {
			throw new Exception("role is null or roleId is null");
		}
	}
}
