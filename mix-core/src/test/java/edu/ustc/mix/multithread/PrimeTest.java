package edu.ustc.mix.multithread;

import org.junit.Test;

public class PrimeTest {
	
	@Test
	public void testPrime() throws Exception {
		for(int i = 0; i < 10; i++) {
			new PrimeThread(i).start();
			new Thread(new PrimeRun(i)).start();
		}
	}
}
