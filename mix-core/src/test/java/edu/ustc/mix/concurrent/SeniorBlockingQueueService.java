package edu.ustc.mix.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"rawtypes","unchecked"})
public class SeniorBlockingQueueService {
	
	public void run() throws InterruptedException {
		
		// 声明一个容量为10的缓存队列
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		// 借助Executors
		ExecutorService service = Executors.newCachedThreadPool();
		
		// 启动线程
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);
		
		Thread.sleep(1000 * 10);
		
		// 停止生产者
		producer1.stop();
		producer2.stop();
		producer3.stop();
		
		Thread.sleep(2000);
		
		// 退出Executor
		service.shutdown();
	}
	
	class Consumer implements Runnable {
		
		private BlockingQueue<String> queue;
		private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;
		
		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}
		
		public void run() {
			
			System.out.println("启动消费者线程！");
			
			boolean isRunning = true;
			
			try {
				while (isRunning) {
					
					System.out.println("正从队列获取数据...");
					
					String data = queue.poll(2, TimeUnit.SECONDS);
					if (null != data) {
						
						System.out.println("拿到数据：" + data);
						System.out.println("正在消费数据：" + data);
						
						Random random = new Random();
						Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
					} else {
						// 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程
						isRunning = false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				System.out.println("退出消费者线程！");
			}
		}
	}
	
	class Producer implements Runnable {
		
		private volatile boolean isRunning = true;
		private BlockingQueue queue;
		private AtomicInteger count = new AtomicInteger();
		private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;
		
		public Producer(BlockingQueue queue) {
			this.queue = queue;
		}
		
		public void run() {
			
			System.out.println("启动生产者线程！");
			
			try {
				while (isRunning) {
					
					System.out.println("正在生产数据...");
					
					Random random = new Random();
					Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
					
					String data = "data:" + count.incrementAndGet();
					System.out.println("将数据：" + data + "放入队列...");
					
					if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
						System.out.println("放入数据失败：" + data);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				System.out.println("退出生产者线程！");
			}
		}
		
		public void stop() {
			isRunning = false;
		}
	}
}
