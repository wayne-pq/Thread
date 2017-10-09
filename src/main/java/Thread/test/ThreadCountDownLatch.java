package Thread.test;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 适用于等待其它线程完成，然后自己的线程才开始运行的情况
 */
public class ThreadCountDownLatch {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);


        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /**
                         * 使当前线程等待，直到latch的count降到0
                         * Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted.
                         */
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : 终于轮到我了");
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : start");
                    /**
                     * 使latch的次数减一，当count次数为0时释放所有的锁
                     * Decrements the count of the latch, releasing all waiting threads if
                     * the count reaches zero.
                     *
                     */
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
