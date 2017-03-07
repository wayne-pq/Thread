package Thread.lock.bean;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 原子值
 *
 * @author panqian
 * @date 2016年12月25日 下午2:35:43
 */
public class Bank_6 extends Bank {

    LongAdder atomicNum = new LongAdder();

    public Bank_6(long num) {
        atomicNum.add(num);
    }

    /**
     * 读
     */
    @Override
    public void topUp() {
        System.out.println(Thread.currentThread().getName() + ": 剩余 " + atomicNum.longValue());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 写
     */
    @Override
    public void consume() {
        if (atomicNum.longValue() <= 0)
            return;
        else {
            atomicNum.decrement();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
