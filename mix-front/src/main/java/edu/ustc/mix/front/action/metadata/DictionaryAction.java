package edu.ustc.mix.front.action.metadata;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping(value = "/dictionary")
public class DictionaryAction {
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		return "/metadata/dictionary";
	}
}
