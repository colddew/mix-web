package edu.ustc.mix.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.permission.ResourceService;

@Controller
@Scope("prototype")
@RequestMapping(value = "/resource")
public class ResourceAction {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/resource";
	}
}
