package edu.ustc.mix.service.provider;

import edu.ustc.mix.service.DubboService;

public class DubboServiceProvider implements DubboService {
	
	@Override
	public String invoke(String name) {
		
		return "hello " + name;
	}
}
