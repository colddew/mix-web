package edu.ustc.mix.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class CountDownLatchService {
	
	public void signal() throws Exception {
		
		// 倒计数锁存器
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);
		
		for(int i = 0; i < 10; ++i) {
			// create and start threads
			new Thread(new SignalWorker(startSignal, doneSignal)).start();
		}
		
		// doSomethingElse(); // don't let run yet
		System.out.println("CountDownLatch startSignal is " + startSignal.getCount());
		startSignal.countDown(); // let all threads proceed
		System.out.println("CountDownLatch startSignal is " + startSignal.getCount());
		
		// doSomethingElse();
		doneSignal.await(); // wait for all to finish
		System.out.println("CountDownLatch doneSignal is " + doneSignal.getCount());
	}
	
	public void execute() throws Exception {
		
		CountDownLatch doneSignal = new CountDownLatch(10);
		Executor executor = new Executor() {
			@Override
			public void execute(Runnable runnable) {
				runnable.run();
			}
		};
		
		for (int i = 0; i < 10; ++i) {
			// create and start threads
			executor.execute(new ExecutorWorker(doneSignal, i));
		}
		
		doneSignal.await(); // wait for all to finish
	}
	
	class SignalWorker implements Runnable {
		
		// 启动信号，在driver为继续执行worker做好准备之前，它会阻止所有的worker继续执行
		private final CountDownLatch startSignal;
		// 完成信号，它允许driver在完成所有worker之前一直等待
		private final CountDownLatch doneSignal;
		
		public SignalWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}
		
		public void run() {
			try {
				startSignal.await();
				doWork();
				doneSignal.countDown();
			} catch (Exception ex) {
				
			}
		}
		
		public void doWork() {
			System.out.println("do somethings");
		}
	}
	
	class ExecutorWorker implements Runnable {
		
		private final CountDownLatch doneSignal;
		private final int i;
		
		public ExecutorWorker(CountDownLatch doneSignal, int i) {
			this.doneSignal = doneSignal;
			this.i = i;
		}
		
		public void run() {
			try {
				doWork(i);
				doneSignal.countDown();
			} catch (Exception ex) {
				
			}
		}
		
		public void doWork(int i) {
			System.out.println("do somethings " + i);
		}
	}
}
