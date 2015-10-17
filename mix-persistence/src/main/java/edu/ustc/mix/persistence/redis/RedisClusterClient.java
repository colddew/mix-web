package edu.ustc.mix.persistence.redis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
		
		Map<String, String> inviteePhone = new HashMap<String, String>();
		inviteePhone.put("inviterID", "1001");
		inviteePhone.put("status", "0");
		cluster.hmset("inviteePhone", inviteePhone);
		
		System.out.println(cluster.hget("inviteePhone", "inviterID"));
		System.out.println(cluster.hget("inviteePhone", "status"));
	}
}
