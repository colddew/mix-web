package edu.ustc.mix.core.security.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.util.CollectionUtils;

import edu.ustc.mix.core.util.RedisUtils;
import edu.ustc.mix.core.util.SerializeUtils;

public class RedisCacheManager implements Cache<String, Object> {
	
	@Override
	public Object get(String key) throws CacheException {
		
		return RedisUtils.get(key.getBytes());
	}
	
	@Override
	public Object put(String key, Object value) throws CacheException {
		
		return RedisUtils.put(key.getBytes(), SerializeUtils.serialize(value));
	}
	
	@Override
	public Object remove(String key) throws CacheException {
		
		return RedisUtils.remove(key.getBytes());
	}
	
	@Override
	public void clear() throws CacheException {
		
		RedisUtils.clear();
	}
	
	@Override
	public int size() {
		
		return RedisUtils.size();
	}
	
	@Override
	public Set<String> keys() {
		
		return RedisUtils.keys("*");
	}
	
	@Override
	public Collection<Object> values() {
		
		List<Object> values = new ArrayList<Object>();
		
		Set<String> keys = keys();
		if(!CollectionUtils.isEmpty(keys)) {
			for(String key : keys) {
				values.add(get(key));
			}
		}
		
		return values;
	}
}
