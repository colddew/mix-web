package edu.ustc.mix.front.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping(value = "/organization")
public class OrganizationAction {
	
	@RequestMapping("/index")
	public String list() throws Exception {
		
		return "/organization";
	}
}
