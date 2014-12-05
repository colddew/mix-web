package edu.ustc.mix.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.Admin;
import edu.ustc.mix.persistence.mapper.AdminMapper;

@Service
public class AdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	public List<Admin> list;
	
	public List<Admin> getAdminList() throws Exception {
		
		return adminMapper.list(null);
	}
	
	public Map<String, Admin> getAdminMapByUserName(List<Admin> list) throws Exception {
		
		Map<String, Admin> map = new HashMap<String, Admin>();
		
		if(list != null && list.size() > 0) {
			for(Admin admin : list) {
				String userName = admin.getUserName();
				map.put(userName, admin);
			}
		}
		
		return map;
	}
	
	public void service() throws Exception {
		
		long start = System.currentTimeMillis();
		
		if(list == null || list.size() < 1) {
			list = getAdminList();
		}
		
		Map<String, Admin> map = getAdminMapByUserName(list);
		
		for(Admin admin : list) {
			String userName = admin.getUserName();
			System.out.println(userName);
			System.out.println(map.get(userName));
		}
		
		System.out.println("##### cost " + (System.currentTimeMillis() - start) + "ms ####");
	}
}
