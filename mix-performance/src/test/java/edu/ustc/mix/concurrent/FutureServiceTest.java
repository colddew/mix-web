package edu.ustc.mix.concurrent;

import org.junit.Test;

public class FutureServiceTest {
	
	@Test
	public void testShowSearchWithFuture() throws Exception {
		FutureService service = new FutureService();
		service.showSearchWithFuture("future");
	}
	
	@Test
	public void testShowSearchWithFutureTask() throws Exception {
		FutureService service = new FutureService();
		service.showSearchWithFutureTask("futureTask");
	}
}
