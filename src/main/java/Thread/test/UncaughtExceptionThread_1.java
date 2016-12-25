package Thread.test;

import Thread.UncaughtException.UncaughtExceptionHandler;
import Thread.UncaughtException.UncaughtExceptionRunnable_1;

/**
 * 捕获线程异常
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class UncaughtExceptionThread_1 {

	public static void main(String[] args) {

		UncaughtExceptionRunnable_1 uncaughtRunnable_1 = new UncaughtExceptionRunnable_1();
		final Thread thread = new Thread();
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
		thread.start();
		
	}

}