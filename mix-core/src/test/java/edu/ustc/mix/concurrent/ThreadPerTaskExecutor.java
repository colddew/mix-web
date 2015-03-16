package edu.ustc.mix.concurrent;

import java.util.concurrent.Executor;

/**
 * 为每个任务生成一个新线程
 */
class ThreadPerTaskExecutor implements Executor {
	public void execute(Runnable r) {
		new Thread(r).start();
	}
}