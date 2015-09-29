package edu.ustc.mix.core.security.cache;

import org.apache.shiro.cache.Cache;

import edu.ustc.mix.core.util.RedisUtils;

public class RedisShiroCacheManager implements ShiroCacheManager {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Cache getCache(String name) {
		
		return new RedisCacheManager();
	}
	
	@Override
	public void destroy() {
		
		RedisUtils.destory();
	}
}
