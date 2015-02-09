package edu.ustc.mix.service.provider;

import com.alibaba.dubbo.config.annotation.Service;

import edu.ustc.mix.service.DubboAnnotationService;

@Service(group = "mix")
public class DubboAnnotationServiceProvider implements DubboAnnotationService {
	
	@Override
	public String invoke(String name) {
		
		return "hello " + name;
	}
}
