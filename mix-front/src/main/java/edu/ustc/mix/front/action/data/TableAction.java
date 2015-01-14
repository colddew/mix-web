package edu.ustc.mix.front.action.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping(value = "/table")
public class TableAction {
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		return "/data/table";
	}
}
