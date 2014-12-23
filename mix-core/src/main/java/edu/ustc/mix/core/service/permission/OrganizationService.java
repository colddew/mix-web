package edu.ustc.mix.core.service.permission;

import java.util.List;

import edu.ustc.mix.persistence.entity.permission.Organization;

public interface OrganizationService {
	
	public List<Organization> getAllOrganizations() throws Exception;
}
