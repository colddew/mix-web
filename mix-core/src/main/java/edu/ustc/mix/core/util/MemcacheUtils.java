package edu.ustc.mix.core.util;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

public class MemcacheUtils {
	
	public static final Integer RESPONSE_STAT_INTERVAL = 5 * 1000;
	public static final String CACHE_CLIENT_NAME = "mclient0";
	
	private static IMemcachedCache cache;
	
	static {

		ICacheManager<IMemcachedCache> manager = CacheUtil.getCacheManager(IMemcachedCache.class, 
				MemcachedCacheManager.class.getName());
		
		manager.setResponseStatInterval(RESPONSE_STAT_INTERVAL);
		manager.start();
		
		cache = manager.getCache(CACHE_CLIENT_NAME);
	}
	
	public static void put(String key, Object value, int expiration) {
		
		cache.put(key, value, expiration);
	}
	
	public static Object get(String key) {
		
		return cache.get(key);
	}
}
