package edu.ustc.mix.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCount {
	
	AtomicInteger count = new AtomicInteger(0);
	
	static class Job implements Runnable {
		
		private AtomicCount count;
		// CountDownLatch用于在保持给定数目的信号、事件或条件前阻塞执行
		private CountDownLatch latch;
		
		public Job(AtomicCount count, CountDownLatch latch) {
			this.count = count;
			this.latch = latch;
		}
		
		@Override
		public void run() {
			
			boolean flag = false;
			while(!flag) {
				int c = count.count.get();
				flag = count.count.compareAndSet(c, c + 1);
			}
			
			latch.countDown();
		}
	}
	
	public int count() throws Exception {
		
		CountDownLatch latch = new CountDownLatch(1500);
		AtomicCount count = new AtomicCount();
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 1500; i++) {
			executor.execute(new Job(count, latch));
		}
		
		latch.await();
		executor.shutdown();
		
		return count.count.get();
	}
}
