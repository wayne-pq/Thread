package Thread.lock.bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 阻塞线程
 * 
 * @author panqian
 * @date 2016年12月25日 下午2:35:43
 */
public class Bank_5 extends Bank {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private Lock writeLock = lock.writeLock();

	int num;

	public Bank_5(int num) {
		this.num = num;
	}

	@Override
	public int add() {

		writeLock.lock();

		try{
			Thread.sleep(1);
			System.out.println(Thread.currentThread().getName()+"生产 : "+ ++num);
			return num;
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			writeLock.unlock();
		}

		return -1;
	}
}
