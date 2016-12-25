package Thread.test;

import Thread.lock.ThreadLocalRunnable_1;
import Thread.lock.bean.Bank_3;

public class ThreadLocalThread_1 {

	public static void main(String[] str) {
		Bank_3 bank_3 = new Bank_3();

		ThreadLocalRunnable_1 threadLocalRunnable_1 = new ThreadLocalRunnable_1(bank_3);
		ThreadLocalRunnable_1 threadLocalRunnable_2 = new ThreadLocalRunnable_1(bank_3);
		Thread l1 = new Thread(threadLocalRunnable_1);
		Thread l2 = new Thread(threadLocalRunnable_2);
		l1.start();
		l2.start();
	}
}
