package edu.ustc.mix.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
	
	// 可以使用tryLock获得锁并指定等待时间
	// ReentrantLock构造函数可以指定公平锁使得必须按照锁的先后顺序来获得锁
	// 可以绑定Condition实现精细化同步控制
	private ReentrantLock lock = new ReentrantLock();
	
	int count = 0;
	
	public int count() throws Exception {
		
		CountDownLatch latch = new CountDownLatch(1500);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 1500; i++) {
			executor.execute(new Job(this, latch));
		}
		
		latch.await();
		executor.shutdown();
		
		return count;
	}
	
	static class Job implements Runnable {
		
		private Count count;
		private CountDownLatch latch;
		
		public Job(Count count, CountDownLatch latch) {
			this.count = count;
			this.latch = latch;
		}
		
		@Override
		public void run() {
			
			count.lock.lock();
			count.count++;
			count.lock.unlock();
			
			latch.countDown();
		}
	}
}
