package edu.ustc.mix.core.service.metadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ralasafe.Ralasafe;
import org.ralasafe.entitle.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mix.core.util.CommonUtils;
import edu.ustc.mix.core.util.PrivilegeConstants;
import edu.ustc.mix.persistence.entity.metadata.MetadataTable;
import edu.ustc.mix.persistence.entity.system.User;
import edu.ustc.mix.persistence.mapper.metadata.MetadataTableMapper;

@Service
public class MetadataTableServiceImpl implements MetadataTableService {
	
	@Autowired
	private MetadataTableMapper metadataTableMapper;
	
	@Override
	public List<MetadataTable> getAllMetadataTables() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		return metadataTableMapper.list(params);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MetadataTable> getAllMetadataTables(User user) throws Exception {
		
		QueryResult queryResult = Ralasafe.query(PrivilegeConstants.QUERY_METADATA_TABLE, 
				CommonUtils.convertMixUserToRalasafeUser(user), null);
		
		List<MetadataTable> allMetadataTables = (List<MetadataTable>) queryResult.getData();
		
		return allMetadataTables;
	}
}
