package edu.ustc.mix.persistence.redis;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RBucket;

public class RedissonClient {
	
	public static void main(String[] args) {
		
		Config config = new Config();
		config.useClusterServers().setScanInterval(2000) // sets cluster state scan interval
		    .addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001", "127.0.0.1:7002")
		    .addNodeAddress("127.0.0.1:7003", "127.0.0.1:7004", "127.0.0.1:7005");
		
		Redisson redisson = Redisson.create(config);
		
		RBucket<Integer> bucket = redisson.getBucket("test");
		bucket.set(6379);
		
		System.out.println(bucket.get());
	}
}
