package Thread.test;

import Thread.lock.ReadLockRunnable_1;
import Thread.lock.WriteLockRunnable_1;
import Thread.lock.bean.Bank_4;

import java.util.concurrent.*;

/**
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class ReadWriteLockThread_1 {

    public static void main(String[] args) {

        Bank_4 bank = new Bank_4(100);

        ReadLockRunnable_1 runnable_1 = new ReadLockRunnable_1(bank);
        WriteLockRunnable_1 runnable_2 = new WriteLockRunnable_1(bank);

        ExecutorService pool = new ThreadPoolExecutor(0, 6, 3L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        for (int i = 0; i < 1; i++) {
            pool.submit(runnable_1);
        }
        for (int i = 0; i < 5; i++) {
            pool.submit(runnable_2);
        }

        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("largestPoolSize is " + largestPoolSize + " 个");


    }

}