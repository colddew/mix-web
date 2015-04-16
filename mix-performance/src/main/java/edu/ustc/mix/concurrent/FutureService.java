package edu.ustc.mix.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Future表示异步计算的结果，它提供了检查计算是否完成、获取计算的结果、取消计算等方法
 */
public class FutureService {
	
	ExecutorService executor = Executors.newFixedThreadPool(5);
	
	ArchiveSearcher searcher = new ArchiveSearcher() {
		@Override
		public String search(String target) {
			return target;
		}
	};
	
	public void showSearchWithFuture(final String target) throws Exception {
		
		// Callable接口类似于Runnable，两者都是为其实例可能被另一个线程执行的类设计的，区别在于Callable返回结果并且可能抛出异常的任务
		Future<String> future = executor.submit(new Callable<String>() {
			public String call() throws Exception {
				
				String search = searcher.search("future call return " + target);
				Thread.sleep(1000*5);
				
				return search;
			}
		});
		
		// doOtherThings();
		
		// cancel switch
		System.out.println(future.isCancelled());
		future.cancel(false);
		System.out.println(future.isCancelled());
		
		try {
			System.out.println(future.get()); // use future
		} catch (Exception ex) {
			
		}
	}
	
	public void showSearchWithFutureTask(final String target) throws Exception {
		
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				
				String search = searcher.search("future task call return " + target);
				Thread.sleep(1000*5);
				
				return search;
			}
		});
		
		executor.execute(task);
		
		// doOtherThings();
		
		try {
			System.out.println(task.get());
		} catch (Exception ex) {
			task.cancel(false);
		}
	}
	
	interface ArchiveSearcher {
		String search(String target);
	}
}
