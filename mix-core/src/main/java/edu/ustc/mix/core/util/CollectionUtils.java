package edu.ustc.mix.core.util;

import java.util.Collection;

public class CollectionUtils {
	
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Collection collection) throws Exception {
		
		if(null != collection && !collection.isEmpty()) {
			
			return true;
		}
		
		return false;
	}
}
