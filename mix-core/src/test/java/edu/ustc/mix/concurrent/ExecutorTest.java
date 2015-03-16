package edu.ustc.mix.concurrent;

import java.util.concurrent.Executor;

import org.junit.Test;

/**
 * 将任务提交与每个任务将如何运行的机制（包括线程使用的细节、调度等）分离开来的方法，通常使用 Executor 而不是显式地创建线程
 */
public class ExecutorTest {
	
	@Test
	public void testDirectExecutor() throws Exception {
		
		Executor executor = new DirectExecutor();
		
		executor.execute(new ExecutorRunnable());
	}
	
	@Test
	public void testThreadPerTaskExecutor() throws Exception {
		
		Executor executor = new ThreadPerTaskExecutor();
		
		executor.execute(new ExecutorRunnable());
	}
	
	@Test
	public void testSerialExecutor() throws Exception {
		
		Executor threadPerTaskExecutor = new ThreadPerTaskExecutor();
		Executor executor = new SerialExecutor(threadPerTaskExecutor);
		
		executor.execute(new ExecutorRunnable());
	}
	
	class ExecutorRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("runnable");
		}
	}
}
