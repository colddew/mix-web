package edu.ustc.mix.persistence.redis;

import redis.clients.jedis.Jedis;

public class RedisClient {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Jedis redis = new Jedis("192.168.199.199", 6379);
		
		redis.set("redis", "redis");
		System.out.println(redis.get("redis"));
		
		redis.hset("map", "alipay", "alipay");
		redis.hset("map", "aliyun", "aliyun");
		redis.hset("map", "tmall", "tmall");
		System.out.println(redis.hgetAll("map"));
		
		redis.del("list");
		redis.lpush("list", "base");
		redis.lpush("list", "left");
		redis.rpush("list", "right");
		System.out.println(redis.llen("list"));
		redis.lpop("list");
		redis.rpop("list");
		System.out.println(redis.llen("list"));
		
		redis.sadd("set", "1");
		redis.sadd("set", "2");
		redis.sadd("set", "1");
		System.out.println(redis.smembers("set"));
	}
}
