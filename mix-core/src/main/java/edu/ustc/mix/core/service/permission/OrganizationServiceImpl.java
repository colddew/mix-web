package edu.ustc.mix.core.service.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.permission.Organization;
import edu.ustc.mix.persistence.mapper.permission.OrganizationMapper;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Override
	public List<Organization> getAllOrganizations() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return organizationMapper.list(params);
	}
}
