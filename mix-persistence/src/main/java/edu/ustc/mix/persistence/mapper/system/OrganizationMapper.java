package edu.ustc.mix.persistence.mapper.system;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.system.Organization;

public interface OrganizationMapper {
	
	int add(Organization organization);
	
	int delete(Long orgId);
	
	int update(Organization organization);
	
	Organization getById(Long orgId);
	
	Organization getByMultiParams(Map<String, Object> params);
	
	List<Organization> list(Map<String, Object> params);
	
	long count(Map<String, Object> params);
}