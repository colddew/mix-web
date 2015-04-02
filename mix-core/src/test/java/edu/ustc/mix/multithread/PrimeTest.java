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
	
	@Test
	public void testJoin() throws Exception {
		
		for(int i = 0; i < 50; i++) {
			PrimeThread primeThread = new PrimeThread(i);
			primeThread.start();
			primeThread.join();
		}
		
		Thread thread = new Thread(new PrimeRun(999));
		thread.start();
	}
}
