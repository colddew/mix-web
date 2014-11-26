package edu.ustc.sse.mix.front.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class IndexAction {
	
	@RequestMapping("/index")
	public String index() throws Exception {
		
		return "/index";
	}
}
