package edu.ustc.mix.concurrent;

import java.util.concurrent.Executor;

/**
 * 执行程序可以在调用者的线程中立即运行已提交的任务
 */
class DirectExecutor implements Executor {
	public void execute(Runnable r) {
		r.run();
	}
}