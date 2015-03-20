package edu.ustc.mix.concurrent;

/**
 * Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作，允许更灵活的结构
 * 锁是控制多个线程对共享资源进行访问的工具，通常锁提供了对共享资源的独占访问
 */
public class LockService {
	
	// ReentrantLock允许对共享资源并发访问
	public void mutexLock() throws Exception {
		
	}
	
	// 与互斥锁相比，读-写锁允许对共享数据进行更高级别的并发访问，带来更大的性能提高
	// 使用读-写锁能否提升性能则取决于读写操作期间读取数据相对于修改数据的频率，以及数据的争用（即在同一时间试图对该数据执行读取或写入操作的线程数）
	// 只有通过分析和测量，才能确定应用程序是否适合使用读-写锁
	public void readWriteLock() throws Exception {
		
	}
}
