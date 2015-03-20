package edu.ustc.mix.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue可以安全地与多个生产者和多个消费者一起使用
 */
public class BlockingQueueService {
	
	/**
	 * 一个由数组支持的有界阻塞队列，按FIFO（先进先出）原则对元素进行排序
	 * 一旦创建了缓存区，就不能再增加其容量，试图向已满队列中放入元素会导致操作受阻塞，试图从空队列中提取元素将导致类似阻塞
	 * 通过将公平性（fairness）设置为true而构造的队列允许按照FIFO顺序访问线程，公平性通常会降低吞吐量
	 */
	public void workWithArrayBlockingQueue() {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		work(queue);
	}
	
	/**
	 * 基于已链接节点和任选范围的阻塞队列，按FIFO（先进先出）排序元素
	 * 链接队列的吞吐量通常要高于基于数组的队列，但是在大多数并发应用程序中其可预知的性能要低
	 */
	public void workWithLinkedBlockingQueue() {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
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
