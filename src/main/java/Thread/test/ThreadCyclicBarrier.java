package Thread.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 * 适用于等待其它线程完成，然后所有线程一起接着运行的情况
 */
public class ThreadCyclicBarrier {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /**
                         * 使当前线程等待，直到所有的parties调用了await()
                         * Waits until all parties have invoked await on this barrier.
                         */
                        System.out.println(Thread.currentThread().getName() + " is prepared, waiting for others");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : 一起开始吧");
                }
            }).start();
        }

    }
}
