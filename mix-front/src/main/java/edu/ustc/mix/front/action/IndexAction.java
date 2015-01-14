package edu.ustc.mix.front.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.security.SystemUser;
import edu.ustc.mix.persistence.entity.permission.User;

@Controller
@Scope("prototype")
public class IndexAction {
	
	private Logger logger = LoggerFactory.getLogger(IndexAction.class);
	
	@RequestMapping("/index")
	public String index(@SystemUser User user, Model model) throws Exception {
		
		logger.info("hello {}, welcome to mix world", user.getUserName());
		
		return "/index";
	}
}
