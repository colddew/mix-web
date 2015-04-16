package edu.ustc.mix.concurrent;

import org.junit.Test;

public class BlockingQueueServiceTest {
	
	@Test
	public void testWorkWithArrayBlockingQueue() throws Exception {
		BlockingQueueService service = new BlockingQueueService();
		service.workWithLinkedBlockingQueue();
	}
	
	@Test
	public void testWorkWithLinkedBlockingQueue() throws Exception {
		BlockingQueueService service = new BlockingQueueService();
		service.workWithLinkedBlockingQueue();
	}
}
