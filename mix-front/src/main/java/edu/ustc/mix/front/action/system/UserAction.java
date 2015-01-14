package edu.ustc.mix.front.action.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ustc.mix.core.dto.UserDto;
import edu.ustc.mix.core.service.system.OrganizationService;
import edu.ustc.mix.core.service.system.RoleService;
import edu.ustc.mix.core.service.system.UserService;
import edu.ustc.mix.persistence.entity.system.User;

@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		model.addAttribute("allUsers", userService.getAllUsersAndRelatedInfo());
		
		return "/system/user";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) throws Exception {
		
		model.addAttribute("user", new User());
		model.addAttribute("allOrganizations", organizationService.getAllOrganizations());
		model.addAttribute("allRoles", roleService.getAllRoles());
		
		return "/system/user-edit";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(UserDto userDto, Model model) throws Exception {
		
		userService.createUserAndRelatedRoles(userDto);
		
		return "redirect:/user/index.html";
	}
	
	@RequestMapping(value = "/{userId}/update", method = RequestMethod.GET)
	public String update(@PathVariable Long userId, Model model) throws Exception {
		
		validateUserId(userId);
		
		model.addAttribute("user", userService.getUserAndRelatedInfo(userId));
		model.addAttribute("allOrganizations", organizationService.getAllOrganizations());
		model.addAttribute("allRoles", roleService.getAllRoles());
		
		return "/system/user-edit";
	}
	
	@RequestMapping(value = "/{userId}/update", method = RequestMethod.POST)
	public String update(UserDto userDto, Model model) throws Exception {
		
		validateUser(userDto);
		
		userService.updateUserAndRelatedRoles(userDto);
		
		return "redirect:/user/index.html";
	}
	
	private void validateUserId(Long userId) throws Exception {
		
		if(null == userId) {
			throw new Exception("userId is null");
		}
	}
	
	private void validateUser(UserDto userDto) throws Exception {
		
		if(null == userDto || null == userDto.getUserId()) {
			throw new Exception("user is null or userId is null");
		}
	}
}
