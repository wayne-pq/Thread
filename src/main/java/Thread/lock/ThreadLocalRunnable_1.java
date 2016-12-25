package Thread.lock;

import Thread.lock.bean.Bank;

/**
 * 测试线程局部变量
 * 
 * @author panqian
 * @date 2016年12月24日 下午8:14:08
 */
public class ThreadLocalRunnable_1 implements Runnable {

	Bank bank;

	public ThreadLocalRunnable_1(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			bank.consume();
		}
	}

}