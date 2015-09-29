package edu.ustc.mix.core.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisClusterUtils {
	
	public static final String NODES = "127.0.0.1:7000;127.0.0.1:7001;127.0.0.1:7002;127.0.0.1:7003;127.0.0.1:7004;127.0.0.1:7005";
	public static final int TIMEOUT = 5000;
	
	private static JedisCluster cluster;
	
	static {
		
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("127.0.0.1", 7000));
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		nodes.add(new HostAndPort("127.0.0.1", 7004));
		nodes.add(new HostAndPort("127.0.0.1", 7005));
		
		cluster = new JedisCluster(nodes, TIMEOUT);
	}
	
	public static String put(String key, String value) {
		
		return cluster.set(key, value);
	}
	
	public static Long remove(String key) {
		
		return cluster.del(key);
	}
	
	public static void clear() {
		
		cluster.flushAll();
	}
	
	public static int size() {
		
		throw new RuntimeException("does not support the operation");
	}
	
	public static Set<String> keys() {
		
		throw new RuntimeException("does not support the operation");
	}
	
	public static Collection<Object> values() {
		
		throw new RuntimeException("does not support the operation");
	}
	
	public static String put(String key, String value, int expiration) {
		
		return cluster.setex(key, expiration, value);
	}
	
	public static String get(String key) {
		
		return cluster.get(key);
	}
	
	public static void destory() {
		
		cluster.shutdown();
	}
}
