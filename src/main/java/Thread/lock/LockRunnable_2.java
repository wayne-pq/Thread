package Thread.lock;

import Thread.lock.bean.Bank;
import Thread.lock.bean.Bank_1;

/**
 * 演示多线程对同一个资源进行操作
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class LockRunnable_2 implements Runnable {

	Bank bank;

	public LockRunnable_2(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			bank.topUp();
		}
	}

}