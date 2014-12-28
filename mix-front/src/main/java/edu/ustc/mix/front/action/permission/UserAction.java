package edu.ustc.mix.front.action.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.permission.UserService;

@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		model.addAttribute("allUsers", userService.getAllUsers());
		
		return "/user";
	}
}
