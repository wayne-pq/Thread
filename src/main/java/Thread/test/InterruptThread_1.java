package Thread.test;

import Thread.interrupt.InterruptRunnable_1;

/**
 * 试验中断线程
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class InterruptThread_1 {

	public static void main(String[] args) {

		InterruptRunnable_1 interruptRunnable_1 = new InterruptRunnable_1();
		final Thread thread = new Thread(interruptRunnable_1);
		thread.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(1000);
					thread.interrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}