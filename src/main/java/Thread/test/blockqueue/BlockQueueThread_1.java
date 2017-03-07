package Thread.test.blockqueue;

import Thread.blockqueue.ConsumeRunnable_1;
import Thread.blockqueue.ProduceRunnable_1;
import Thread.lock.bean.Bank_5;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产线程向队列插入数据，消费者线程则是取出数据
 */
public class BlockQueueThread_1 {

	public static void main(String[] str) {

		Bank_5 bank_5 = new Bank_5(0);

		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

		ConsumeRunnable_1 consumeRunnable_1 = new ConsumeRunnable_1(queue,bank_5);
		ProduceRunnable_1 produceRunnable_1 = new ProduceRunnable_1(queue,bank_5);

		for(int i=0;i<2;i++){
			new Thread(produceRunnable_1).start();
		}

		for (int i=0;i<2;i++){
			new Thread(consumeRunnable_1).start();
		}


	}
}
