package edu.ustc.mix.front.action.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ustc.mix.core.dto.ResourceDto;
import edu.ustc.mix.core.service.system.ResourceService;
import edu.ustc.mix.persistence.entity.system.Resource;

@Controller
@Scope("prototype")
@RequestMapping(value = "/resource")
public class ResourceAction {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/index")
	public String list(Model model) throws Exception {
		
		model.addAttribute("allResources", resourceService.getAllResources());
		
		return "/system/resource";
	}
	
	@RequestMapping(value = "/{parentId}/create", method = RequestMethod.GET)
	public String create(@PathVariable Long parentId, Model model) throws Exception {
		
		validateParentId(parentId); 
		
		model.addAttribute("resource", new Resource());
		model.addAttribute("parent", resourceService.getResource(parentId));
		
		return "/system/resource-edit";
	}
	
	@RequestMapping(value = "/{parentId}/create", method = RequestMethod.POST)
	public String create(ResourceDto resourceDto, Model model) throws Exception {
		
		resourceService.createResource(resourceDto);
		
		return "redirect:/resource/index.html";
	}
	
	@RequestMapping(value = "/{resId}/update", method = RequestMethod.GET)
	public String update(@PathVariable Long resId, Model model) throws Exception {
		
		validateResId(resId);
		
		model.addAttribute("resource", resourceService.getResource(resId));
		
		return "/system/resource-edit";
	}
	
	@RequestMapping(value = "/{resId}/update", method = RequestMethod.POST)
	public String update(ResourceDto resourceDto, Model model) throws Exception {
		
		validateResource(resourceDto);
		
		resourceService.updateResource(resourceDto);
		
		return "redirect:/resource/index.html";
	}
	
	@RequestMapping(value = "/{resId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable Long resId, Model model) throws Exception {
		
		resourceService.deleteResourceAndRelatedRoles(resId);
		
		return "redirect:/resource/index.html";
	}
	
	private void validateParentId(Long parentId) throws Exception {
		
		if(null == parentId) {
			throw new Exception("parentId is null");
		}
	}
	
	private void validateResId(Long resId) throws Exception {
		
		if(null == resId) {
			throw new Exception("resId is null");
		}
	}
	
	private void validateResource(ResourceDto resourceDto) throws Exception {
		
		if(null == resourceDto || null == resourceDto.getResId()) {
			throw new Exception("resource is null or resId is null");
		}
	}
}
