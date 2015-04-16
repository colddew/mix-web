package edu.ustc.mix.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollection {
	
	static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
	
	static {
		for(int i = 0; i < 100; i++) {
			map.put(i, i);
		}
	}
	
	public void costTime() throws Exception {
		
		long start = System.currentTimeMillis();
		
		ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<Integer, Integer>();
		for(int i = 0; i < 10000; i++) {
			concurrentHashMap.put(i, i);
		}
		
		System.out.println("ConcurrentHashMap cost " + (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i = 0; i < 10000; i++) {
			hashmap.put(i, i);
		}
		
		System.out.println("HashMap cost " + (System.currentTimeMillis() - start) + "ms");
	}
	
	public void concurrentOperate() throws Exception {
		
		for(int i = 0; i < 100; i++) {
			new Thread(new ConcurrentReader(i)).start();
		}
		
		new Thread(new ConcurrentWriter(5, 15)).start();
		new Thread(new ConcurrentWriter(5, 25)).start();
		
		Thread thread = new Thread(new ConcurrentWriter(5, 35));
		thread.start();
		thread.join();
	}
	
	class ConcurrentReader implements Runnable {
		
		int key;
		
		public ConcurrentReader(int key) {
			this.key = key;
		}
		
		@Override
		public void run() {
			System.out.println("key is " + key + ", value is " + map.get(key));
		}
	}
	
	class ConcurrentWriter implements Runnable {
		
		int key;
		int value;
		
		public ConcurrentWriter(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public void run() {
			map.put(key, value);
		}
	}
}
