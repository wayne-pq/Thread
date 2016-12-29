package Thread.blockqueue;

import Thread.lock.bean.Bank;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者线程
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class ProduceRunnable_1 implements Runnable {

	private Bank bank;

	private LinkedBlockingQueue<Integer> queue;

	public ProduceRunnable_1(LinkedBlockingQueue<Integer> queue, Bank bank) {
		this.queue = queue;
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			try {
				queue.put(bank.add());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}