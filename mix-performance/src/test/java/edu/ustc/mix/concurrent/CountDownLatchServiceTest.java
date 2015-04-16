package edu.ustc.mix.concurrent;

import org.junit.Test;

public class CountDownLatchServiceTest {
	
	@Test
	public void testSignal() throws Exception {
		CountDownLatchService service = new CountDownLatchService();
		service.signal();
	}
	
	@Test
	public void testExecute() throws Exception {
		CountDownLatchService service = new CountDownLatchService();
		service.execute();
	}
}
