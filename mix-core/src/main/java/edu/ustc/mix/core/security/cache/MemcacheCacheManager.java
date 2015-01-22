package edu.ustc.mix.core.security.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import edu.ustc.mix.core.util.MemcacheUtils;

public class MemcacheCacheManager implements Cache<String, Object> {
	
	@Override
	public Object get(String key) throws CacheException {
		
		return MemcacheUtils.get((String) key);
	}
	
	@Override
	public Object put(String key, Object value) throws CacheException {
		
		return MemcacheUtils.put(key, value);
	}
	
	@Override
	public Object remove(String key) throws CacheException {
		
		return MemcacheUtils.remove(key);
	}
	
	@Override
	public void clear() throws CacheException {
		
		MemcacheUtils.clear();
	}
	
	@Override
	public int size() {
		
		return MemcacheUtils.size();
	}
	
	@Override
	public Set<String> keys() {
		
		return MemcacheUtils.keys();
	}
	
	@Override
	public Collection<Object> values() {
		
		return MemcacheUtils.values();
	}
}
