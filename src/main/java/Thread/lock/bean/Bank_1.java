package Thread.lock.bean;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank_1 extends Bank {

	int Num;

	//lock锁对象  在锁对象内  只有一个线程可以进入
	ReentrantLock lock = new ReentrantLock();
	//条件对象	根据情况对当前线程进行暂停恢复  会释放锁
	Condition sufficientFunds = lock.newCondition();

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	/**
	 * 消费
	 */
	@Override
	public void consume() {
		lock.lock();

		try {
			while (Num <= 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " 线程进入等待");
					sufficientFunds.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Num--;
			System.out.println(Thread.currentThread().getName() + " 消费了,还剩下金额" + Num);

		} finally {
			lock.unlock();
		}

	}

	/**
	 * 充值
	 */
	@Override
	public void topUp() {
		lock.lock();
		try {
			if (Num >= 0) {
				Num++;
				System.out.println(Thread.currentThread().getName() + " 充值了,还剩下金额" + Num);
				sufficientFunds.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

}
