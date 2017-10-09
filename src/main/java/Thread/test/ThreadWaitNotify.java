package Thread.test;

/**
 * thread.join() 方法  ，让其他线程临时加入。
 * Waits for this thread to die.   等待这个线程死亡。
 */
public class ThreadWaitNotify {
    public static void main(String[] args) {

        Object lock = new Object();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print(Thread.currentThread().getName());
                        System.out.print(":");
                        System.out.print(i);
                        System.out.println();
                        if (i == 1) {
                            try {
                                /**
                                 * 让当前线程等待直到另一个线程唤醒(notify() 或者 notifyAll())，并且交出锁的控制权
                                 * Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object.
                                 * In other words, this method behaves exactly as if it simply performs the call wait(0).
                                 */
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread A = new Thread(runnable);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print(Thread.currentThread().getName());
                        System.out.print(":");
                        System.out.print(i);
                        System.out.println();
                    }
                    /**
                     * 唤醒一个正在等待对象锁的线程，如果等待的线程不止一个，只有其中一个线程会被唤醒。
                     * Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be awakened.
                     */
                    lock.notify();
                }
            }
        };

        Thread B = new Thread(runnable1);

        A.start();
        B.start();

//        thread.start();

    }
}
