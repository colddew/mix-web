package edu.ustc.mix.front.action.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.system.OrganizationService;

@Controller
@Scope("prototype")
@RequestMapping(value = "/organization")
public class OrganizationAction {
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		model.addAttribute("allOrganizations", organizationService.getAllOrganizations());
		
		return "/system/organization";
	}
}
