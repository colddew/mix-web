package edu.ustc.mix.front.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.front.service.MixService;

@Controller
@Scope("prototype")
public class LoginAction {
	
	@Resource
	private MixService mixService;
	
	@RequestMapping("/login")
	public String login() throws Exception {
		
		mixService.service();
		
		return "/login";
	}
}
