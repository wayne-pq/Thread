package Thread.test;

import Thread.lock.DeadLock;

public class DeadThread_1 {

	public static void main(String[] str) {
		DeadLock deadLock = new DeadLock();
		DeadLock deadLock2 = new DeadLock();
		deadLock.flag = 0;
		deadLock2.flag = 1;
		Thread l1 = new Thread(deadLock);
		Thread l2 = new Thread(deadLock2);
		l1.start();
		l2.start();
	}
}
