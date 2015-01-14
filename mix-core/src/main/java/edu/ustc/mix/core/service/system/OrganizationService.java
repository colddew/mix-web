package edu.ustc.mix.core.service.system;

import java.util.List;

import edu.ustc.mix.persistence.entity.system.Organization;

public interface OrganizationService {
	
	public List<Organization> getAllOrganizations() throws Exception;
	
	public Organization getOrganization(Long orgId) throws Exception;
}
