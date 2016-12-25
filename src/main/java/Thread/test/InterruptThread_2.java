package Thread.test;

import Thread.interrupt.InterruptRunnable_2;

/**
 * 试验中断线程
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class InterruptThread_2 {

	public static void main(String[] args) {

		InterruptRunnable_2 interruptRunnable_2 = new InterruptRunnable_2();
		final Thread thread = new Thread(interruptRunnable_2);
		thread.start();
		thread.interrupt();

	}

}