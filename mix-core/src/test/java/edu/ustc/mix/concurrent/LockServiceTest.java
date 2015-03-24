package edu.ustc.mix.concurrent;

import org.junit.Test;

public class LockServiceTest {
	
	LockService service = new LockService();
	
	private static final int WRITE_THREAD_QUANTITY = 100;
	private static final int READ_THREAD_QUANTITY = 100000;
	
	@Test
	public void testMutexLock() throws Exception {
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < READ_THREAD_QUANTITY; i++) {
			
			if(i < WRITE_THREAD_QUANTITY) {
				new MutexSetLock(i, Integer.toString(i)).start();
			}
			
			new MutexGetLock(i).start();
		}
		
		System.out.println("testMutexLock cost " + (System.currentTimeMillis() - start) + " ms");
	}
	
	@Test
	public void testReadWriteLock() throws Exception {
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < READ_THREAD_QUANTITY; i++) {
			
			if(i < WRITE_THREAD_QUANTITY) {
				new WriteLock(i, Integer.toString(i)).start();
			}
			
			new ReadLock(i).start();
		}
		
		System.out.println("testReadWriteLock cost " + (System.currentTimeMillis() - start) + " ms");
	}
	
	class MutexGetLock extends Thread {
		
		private Integer key;
		
		public MutexGetLock(Integer key) {
			this.key = key;
		}
		
		@Override
		public void run() {
			try {
				String value = service.mutexGetLock(key);
				System.out.println("MutexGetLock thread, key : " + key + ", value : " + value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class MutexSetLock extends Thread {
		
		private Integer key;
		private String value;
		
		public MutexSetLock(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
			
		@Override
		public void run() {
			try {
				service.mutexSetLock(key, value);
				System.out.println("MutexSetLock thread, key : " + key + ", value : " + value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class ReadLock extends Thread {
		
		private Integer key;
		
		public ReadLock(Integer key) {
			this.key = key;
		}
		
		@Override
		public void run() {
			try {
				String value = service.readLock(key);
				System.out.println("ReadLock thread, key : " + key + ", value : " + value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class WriteLock extends Thread {
		
		private Integer key;
		private String value;
		
		public WriteLock(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public void run() {
			try {
				service.writeLock(key, value);
				System.out.println("WriteLock thread, key : " + key + ", value : " + value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
