package edu.ustc.mix.core.service.openapi;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ustc.mix.core.util.ChannelType;

@Service
public class OpenAPIDispatcher {
	
	@Resource
	private OpenAPI topOpenAPI;
	
	public OpenAPI dispatch(String channel) throws Exception {
		
		if(ChannelType.TOP.name().toLowerCase().equals(channel)) {
			return topOpenAPI;
		} else {
			throw new Exception("channel is not existed");
		}
	}
}
