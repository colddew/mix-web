package edu.ustc.mix.front.action.metadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustc.mix.core.security.SystemUser;
import edu.ustc.mix.core.service.metadata.MetadataTableService;
import edu.ustc.mix.persistence.entity.system.User;

@Controller
@Scope("prototype")
@RequestMapping(value = "/table")
public class MetadataTableAction {
	
	@Autowired
	private MetadataTableService metadataTableService;
	
	@RequestMapping("/index")
	public String list(@SystemUser User user, Model model) throws Exception {
		
		model.addAttribute("allMetadataTables", metadataTableService.getAllMetadataTables(user));
		
		return "/metadata/table";
	}
}
