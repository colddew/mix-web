package edu.ustc.mix.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.Admin;
import edu.ustc.mix.persistence.mapper.AdminMapper;

@Service
public class AdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	public void service() throws Exception {
		
		Admin admin = adminMapper.selectByPrimaryKey(1L);
		System.out.println(admin.getAdminId());
		System.out.println(admin.getUserName());
		System.out.println(admin.getAdminPassword());
	}
}
