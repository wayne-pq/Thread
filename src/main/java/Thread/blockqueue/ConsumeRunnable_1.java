package Thread.blockqueue;

import Thread.lock.bean.Bank;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消费者线程
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class ConsumeRunnable_1 implements Runnable {


	private LinkedBlockingQueue<Integer> queue;

	private Bank bank;

	public ConsumeRunnable_1(LinkedBlockingQueue<Integer> queue, Bank bank) {
		this.queue = queue;
		this.bank = bank;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName()+" ：消费 "+queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}