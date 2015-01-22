package edu.ustc.mix.core.util;

import java.util.Collection;
import java.util.Set;

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
	
	public static Object put(String key, Object value) {
		
		return cache.put(key, value);
	}
	
	public static Object remove(String key) {
		
		return cache.remove(key);
	}
	
	public static void clear() {
		
		cache.clear();
	}
	
	public static int size() {
		
		return cache.size();
	}
	
	public static Set<String> keys() {
		
		return cache.keySet();
	}
	
	public static Collection<Object> values() {
		
		return cache.values();
	}
	
	public static void put(String key, Object value, int expiration) {
		
		cache.put(key, value, expiration);
	}
	
	public static Object get(String key) {
		
		return cache.get(key);
	}
	
	public static void destory() {
		
		cache.destroy();
	}
}
