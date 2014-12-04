package edu.ustc.mix.front.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ustc.mix.core.service.AdminService;

@Service
public class MixService {
	
	@Resource
	private AdminService adminService;
	
	public void service() throws Exception {
		
		adminService.service();
	}
}
