package edu.ustc.mix.persistence.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisClusterClient {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("127.0.0.1", 7000));
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		nodes.add(new HostAndPort("127.0.0.1", 7004));
		nodes.add(new HostAndPort("127.0.0.1", 7005));
		
		JedisCluster cluster = new JedisCluster(nodes, 5000);
		
		System.out.println(cluster.get("foo"));
		
		cluster.set("test", "6379");
		System.out.println(cluster.get("test"));
	}
}
