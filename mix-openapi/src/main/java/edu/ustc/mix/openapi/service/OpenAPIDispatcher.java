package edu.ustc.mix.openapi.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.openapi.utils.ChannelType;

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
