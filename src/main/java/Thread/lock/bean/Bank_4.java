package Thread.lock.bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模拟读写锁
 * 
 * @author panqian
 * @date 2016年12月25日 下午2:35:43
 */
public class Bank_4 extends Bank {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private Lock readLock = lock.readLock();

	private Lock writeLock = lock.writeLock();

	int num;

	public Bank_4(int num) {
		this.num = num;
	}

	/**
	 * 读
	 */
	@Override
	public void topUp() {
		readLock.lock();
		try{
			System.out.println(Thread.currentThread().getName()+": 剩余 "+ num);
		}finally {
			readLock.unlock();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 写
	 */
	@Override
	public void consume() {
		writeLock.lock();

		try{
			if(num<=0)
				return;
			else
				System.out.println(Thread.currentThread().getName()+": 开始消费"+ --num);
		}finally {
			writeLock.unlock();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
