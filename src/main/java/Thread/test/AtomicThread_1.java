package Thread.test;

import Thread.lock.ReadLockRunnable_1;
import Thread.lock.WriteLockRunnable_1;
import Thread.lock.bean.Bank_6;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 原子值LongAdder
 * Created by panqian on 2017/3/7.
 */
public class AtomicThread_1 {
    public static void main(String[] args) {
        Bank_6 bank = new Bank_6(100);

        ReadLockRunnable_1 readLockRunnable_1 = new ReadLockRunnable_1(bank);
        WriteLockRunnable_1 writeLockRunnable_1 = new WriteLockRunnable_1(bank);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 100, 3L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 1; i++) {
            threadPoolExecutor.submit(readLockRunnable_1);
        }
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(writeLockRunnable_1);
        }

    }
}
