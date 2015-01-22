package edu.ustc.mix.core.security.cache;

import org.apache.shiro.cache.Cache;

import edu.ustc.mix.core.util.MemcacheUtils;

public class MemcacheShiroCacheManager implements ShiroCacheManager {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Cache getCache(String name) {
		
		return new MemcacheCacheManager();
	}
	
	@Override
	public void destroy() {
		
		MemcacheUtils.destory();
	}
}
