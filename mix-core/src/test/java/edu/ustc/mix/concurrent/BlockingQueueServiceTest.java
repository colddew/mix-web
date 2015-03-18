package edu.ustc.mix.concurrent;

import org.junit.Test;

public class BlockingQueueServiceTest {
	
	@Test
	public void testWork() throws Exception {
		BlockingQueueService service = new BlockingQueueService();
		service.work();
	}
}
