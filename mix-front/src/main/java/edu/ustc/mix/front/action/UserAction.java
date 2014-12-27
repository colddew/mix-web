package edu.ustc.mix.front.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserAction {
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
//		model.addAttribute("allUsers", organizationService.getAllOrganizations());
		
		return "/user";
	}
}
