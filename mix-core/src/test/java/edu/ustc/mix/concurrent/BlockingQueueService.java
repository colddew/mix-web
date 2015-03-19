package edu.ustc.mix.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue可以安全地与多个生产者和多个消费者一起使用
 */
public class BlockingQueueService {
	
	public void workWithLinkedBlockingQueue() {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		work(queue);
	}
	
	public void workWithArrayBlockingQueue() {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		work(queue);
	}
	
	private void work(BlockingQueue<String> queue) {
		
		Producer p = new Producer(queue);
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
	
	class Producer implements Runnable {
		
		private final BlockingQueue<String> queue;
		
		Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}
		
		public void run() {
			try {
				for(int i = 0; i < 100; i++) {
					queue.put(produce(i));
				}
			} catch (Exception e) {
				
			}
		}
		
		String produce(int i) {
			return "product-" + i;
		}
	}
	
	class Consumer implements Runnable {
		
		private final BlockingQueue<String> queue;
		
		Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}
		
		public void run() {
			try {
				while (true) {
					consume(queue.take());
				}
			} catch (Exception e) {
			}
		}
		
		void consume(String product) {
			System.out.println(product);
		}
	}
}
