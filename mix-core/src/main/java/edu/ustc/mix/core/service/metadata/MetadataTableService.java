package edu.ustc.mix.core.service.metadata;

import java.util.List;

import edu.ustc.mix.persistence.entity.metadata.MetadataTable;
import edu.ustc.mix.persistence.entity.system.User;

public interface MetadataTableService {
	
	public List<MetadataTable> getAllMetadataTables() throws Exception;
	
	public List<MetadataTable> getAllMetadataTables(User user) throws Exception;
}
