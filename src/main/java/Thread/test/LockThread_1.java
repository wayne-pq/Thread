package Thread.test;

import Thread.lock.LockRunnable_1;
import Thread.lock.LockRunnable_2;
import Thread.lock.bean.Bank_1;

/**
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class LockThread_1 {

	public static void main(String[] args) {

		Bank_1 bank = new Bank_1();
		bank.setNum(100);

		LockRunnable_1 runnable_1 = new LockRunnable_1(bank);
		LockRunnable_2 runnable_2 = new LockRunnable_2(bank);

		for (int i = 0; i < 2; i++) {
			final Thread thread = new Thread(runnable_1);
			thread.start();
		}
		
		for (int i = 0; i < 1; i++) {
			final Thread thread = new Thread(runnable_2);
			thread.start();
		}

	}

}