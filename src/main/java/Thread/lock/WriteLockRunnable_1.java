package Thread.lock;

import Thread.lock.bean.Bank;

/**
 * 模拟读写锁
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class WriteLockRunnable_1 implements Runnable {

	Bank bank;

	public WriteLockRunnable_1(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			bank.consume();
		}
	}

}