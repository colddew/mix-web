package edu.ustc.mix.concurrent;

import org.junit.Test;

public class SeniorBlockingQueueServiceTest {
	
	@Test
	public void testRun() throws Exception {
		SeniorBlockingQueueService service = new SeniorBlockingQueueService();
		service.run();
	}
}
