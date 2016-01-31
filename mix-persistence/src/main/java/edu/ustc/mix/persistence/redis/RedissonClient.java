package edu.ustc.mix.persistence.redis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RBucket;
import org.redisson.core.RLock;

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
		
		concurrentLock(redisson);
	}
	
	private static void concurrentLock(final Redisson redisson) {
		
		try {
			Integer nThreads = 10;
			ExecutorService pool = Executors.newFixedThreadPool(nThreads);
			
			for (int i = 0; i < nThreads; i++) {
				
				pool.submit(new Runnable() {
					
					@Override
					public void run() {
						
						RLock lock = redisson.getLock("123456");
						
						try {
							if (lock.tryLock(10, TimeUnit.SECONDS)) {
								Thread.sleep(1000 * 10);
								System.out.println(Thread.currentThread() + "##### first time locked #####");
							} else {
								System.out.println(Thread.currentThread() + "##### already locked #####");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
			pool.shutdown();
			pool.awaitTermination(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
