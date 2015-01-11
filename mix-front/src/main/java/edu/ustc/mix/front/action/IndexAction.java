package edu.ustc.mix.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.permission.ResourceService;
import edu.ustc.mix.core.service.permission.UserService;
import edu.ustc.mix.persistence.entity.permission.User;

@Controller
@Scope("prototype")
public class IndexAction {
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(User user, Model model) throws Exception {
		
//		Set<String> permissions = userService.findPermissions(user.getUserName());
//		
//		List<Resource> menus = resourceService.findMenus(permissions);
//		model.addAttribute("menus", menus);
		
		return "/index";
	}
}
