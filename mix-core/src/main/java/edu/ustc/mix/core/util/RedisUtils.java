package edu.ustc.mix.core.util;

import java.util.Collection;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
	
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 6379;
	
	private static JedisPool pool;
	
	static {
		pool = new JedisPool(new JedisPoolConfig(), HOST, PORT);
	}
	
	public static Object put(byte[] key, byte[] value) {
		
		Jedis jedis = pool.getResource();
		
		try {
			jedis.set(key, value);
		} finally {
			pool.returnResource(jedis);
		}
		
		return value;
	}
	
	public static Object remove(byte[] key) {
		
		Jedis jedis = pool.getResource();
		
		try {
			return jedis.del(key);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static void clear() {
		
		Jedis jedis = pool.getResource();
		
		try {
			jedis.flushAll();
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static int size() {
		
		Jedis jedis = pool.getResource();
		
		try {
			return jedis.dbSize().intValue();
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static Set<String> keys(String pattern) {
		
		Jedis jedis = pool.getResource();
		
		try {
			return jedis.keys(pattern);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static Collection<Object> values() {
		
		throw new RuntimeException("does not support the operation");
	}
	
	public static byte[] put(byte[] key, byte[] value, int expiration) {
		
		Jedis jedis = pool.getResource();
		
		try {
			jedis.setex(key, expiration, value);
		} finally {
			pool.returnResource(jedis);
		}
		
		return value;
	}
	
	public static Object get(byte[] key) {
		
		Jedis jedis = pool.getResource();
		
		try {
			return jedis.get(key);
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public static void destory() {
		
		Jedis jedis = pool.getResource();
		
		try {
			jedis.shutdown();
		} finally {
			pool.returnResource(jedis);
		}
	}
}
