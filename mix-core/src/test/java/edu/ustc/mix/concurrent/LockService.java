package edu.ustc.mix.concurrent;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作，允许更灵活的结构
 * 
 * 锁是控制多个线程对共享资源进行访问的工具，通常锁提供了对共享资源的独占访问
 */
public class LockService {
	
	private final Map<Integer, String> map = new TreeMap<Integer, String>();
	private ReentrantLock lock = new ReentrantLock();
	
	private final Map<Integer, String> rwmap = new TreeMap<Integer, String>();
	private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
	private Lock rlock = rwlock.readLock();
	private Lock wlock = rwlock.writeLock();
	
	// ReentrantLock允许对共享资源并发访问
	public String mutexGetLock(Integer key) throws Exception {
		
		lock.lock();
		
		try {
			return map.get(key);
		} finally {
			lock.unlock();
		}
	}
	
	public void mutexSetLock(Integer key, String value) throws Exception {
		
		lock.lock();
		
		try {
			map.put(key, value);
		} finally {
			lock.unlock();
		}
	}
	
	// 与互斥锁相比，读-写锁允许对共享数据进行更高级别的并发访问，带来更大的性能提高
	// 使用读-写锁能否提升性能则取决于读写操作期间读取数据相对于修改数据的频率，以及数据的争用（即在同一时间试图对该数据执行读取或写入操作的线程数）
	// 已经持有写锁会阻塞希望获取读锁或写锁的线程，已经持有读锁会阻塞希望获取写锁的线程，但不会阻塞希望获取写锁的线程
	// 读锁不能升级为写锁，写锁可以降级为读锁
	public String readLock(Integer key) throws Exception {
		
		rlock.lock();
		
		try {
			return rwmap.get(key);
		} finally {
			rlock.unlock();
		}
	}
	
	public void writeLock(Integer key, String value) throws Exception {
		
		wlock.lock();
		
		try {
			rwmap.put(key, value);
		} finally {
			wlock.unlock();
		}
	}
}
