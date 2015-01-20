package edu.ustc.mix.persistence.mapper.metadata;

import java.util.List;
import java.util.Map;

import edu.ustc.mix.persistence.entity.metadata.MetadataTable;

public interface MetadataTableMapper {
	
	List<MetadataTable> list(Map<String, Object> params);
}