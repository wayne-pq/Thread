package Thread.lock;

import Thread.lock.bean.Bank;

/**
 * 演示多线程对同一个资源进行操作
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class LockRunnable_1 implements Runnable {

	Bank bank;

	public LockRunnable_1(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			bank.consume();
		}
	}

}