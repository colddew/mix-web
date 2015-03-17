package edu.ustc.mix.concurrent;

import org.junit.Test;

public class CountTest {
	
	@Test
	public void testCount() throws Exception {
		Count count = new Count();
		System.out.println(count.count());
	}
}
