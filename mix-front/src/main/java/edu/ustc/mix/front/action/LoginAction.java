package edu.ustc.mix.front.action;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class LoginAction {
	
	private Logger logger = LoggerFactory.getLogger(LoginAction.class);
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) throws Exception {
		
		String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
		logger.info("exception class name is {}", exceptionClassName);
		
		return "/login";
	}
}
