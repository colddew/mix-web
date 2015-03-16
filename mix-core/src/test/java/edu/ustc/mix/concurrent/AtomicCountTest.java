package edu.ustc.mix.concurrent;

import org.junit.Test;

public class AtomicCountTest {
	
	@Test
	public void testCount() throws Exception {
		
		AtomicCount count = new AtomicCount();
		System.out.println(count.count());
	}
}
