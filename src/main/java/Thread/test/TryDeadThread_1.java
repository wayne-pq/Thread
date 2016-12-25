package Thread.test;

import Thread.lock.DeadLock;
import Thread.lock.TryDeadLock;

/**
 * trylock的应用  拿不到锁直接return 避免死锁的情况
 */
public class TryDeadThread_1 {

    public static void main(String[] str) {
        TryDeadLock deadLock = new TryDeadLock();
        TryDeadLock deadLock2 = new TryDeadLock();
        deadLock.flag = 0;
        deadLock2.flag = 1;
        final Thread l1 = new Thread(deadLock);
        final Thread l2 = new Thread(deadLock2);
        l1.start();
        l2.start();


        //线程在等待获得锁的时候   你中断操作不能起作用  无法终止
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(2000);
//					l1.interrupt();
//					l2.interrupt();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();

    }
}
