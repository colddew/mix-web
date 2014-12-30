package edu.ustc.mix.front.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.service.AdminService;
import edu.ustc.mix.front.service.MixService;

@Controller
@Scope("prototype")
public class LoginAction {
	
	@Resource
	private MixService mixService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String login() throws Exception {
		
//		mixService.service();
		
		adminService.init();
		
		return "/login";
	}
}
