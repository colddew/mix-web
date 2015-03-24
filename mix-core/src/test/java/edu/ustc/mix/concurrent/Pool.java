package edu.ustc.mix.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore通常用于限制可以访问某些资源（物理或逻辑的）的线程数目，下面的类使用信号量控制对内容池的访问
 */
class Pool {
	
	private static final int MAX_AVAILABLE = 10;
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
	
	public Object getItem() throws InterruptedException {
		available.acquire();
		return getNextAvailableItem();
	}
	
	public void putItem(Object x) {
		if (markAsUnused(x)) {
			available.release();
		}
	}
	
	// Not a particularly efficient data structure; just for demo
	protected Object[] items = new Object[] {1,2,3,4,5,6,7,8,9,10};
	protected boolean[] used = new boolean[MAX_AVAILABLE];
	
	protected synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null; // not reached
	}
	
	protected synchronized boolean markAsUnused(Object item) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else
					return false;
			}
		}
		return false;
	}
}
