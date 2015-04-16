package edu.ustc.mix.concurrent;

import org.junit.Test;

public class ConcurrentCollectionTest {
	
	@Test
	public void testCostTime() throws Exception {
		ConcurrentCollection collection = new ConcurrentCollection();
		collection.costTime();
	}
	
	@Test
	public void testConcurrentOperate() throws Exception {
		
		ConcurrentCollection collection = new ConcurrentCollection();
		collection.concurrentOperate();
		
		System.out.println(ConcurrentCollection.map.get(5));
	}
}
