package multithreadingtest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		reentrantLock.lock();
		reentrantLock.lock();
		System.out.println(reentrantLock.isLocked()); //true
		System.out.println(reentrantLock.isHeldByCurrentThread()); //true
		System.out.println(reentrantLock.getQueueLength()); //0
		reentrantLock.unlock();
		System.out.println(reentrantLock.getHoldCount()); //1
		System.out.println(reentrantLock.isLocked()); //true
		reentrantLock.unlock();
		System.out.println(reentrantLock.isLocked()); //false
		System.out.println(reentrantLock.isFair()); //false

	}

}
