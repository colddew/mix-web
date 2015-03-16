package edu.ustc.mix.concurrent;

import org.junit.Test;

public class PoolTest {
	
	Pool pool = new Pool();
	
	@Test
	public void testPool() throws Exception {
		for(int i = 0; i < 10; i++) {
			new GetThread(i).start();
			new PutThread(i).start();
		}
	}
	
	class GetThread extends Thread {
		
		private int id;
		
		public GetThread(int id) {
			this.id = id;
		}
		
		@Override
		public void run() {
			try {
				Object item = pool.getItem();
				System.out.println("thread-" + id + ":" + item);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class PutThread extends Thread {
		
		private int id;
		
		public PutThread(int id) {
			this.id = id;
		}
		
		@Override
		public void run() {
			pool.putItem(id);
			System.out.println("thread-" + id);
		}
	}
}
