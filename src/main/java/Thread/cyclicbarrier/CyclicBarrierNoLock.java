package Thread.cyclicbarrier;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: infra-monitor-service
 * @description:
 * @author: qian.pan
 * @create: 2019/07/11 17:09
 **/
public class CyclicBarrierNoLock {

    private final ConcurrentLinkedQueue<Thread> concurrentLinkedQueue;
    private final int parties;
    private final sun.misc.Unsafe UNSAFE;
    private final long countOffset;
    private final Runnable barrierCommand;
    private volatile int count;
    private volatile Object generation;

    public CyclicBarrierNoLock(int count) throws NoSuchFieldException, IllegalAccessException {
        this(count, null);
    }

    public CyclicBarrierNoLock(int count, Runnable barrierCommand) throws NoSuchFieldException, IllegalAccessException {
        this.count = parties = count;
        this.concurrentLinkedQueue = new ConcurrentLinkedQueue();
        generation = new Object();

        //获取 Unsafe 内部的私有的实例化单例对象
        Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        //无视权限
        field.setAccessible(true);
        UNSAFE = (sun.misc.Unsafe) field.get(null);
        Class<?> k = CyclicBarrierNoLock.class;
        countOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("count"));
        this.barrierCommand = barrierCommand;
    }

    public int await() {
        int index;
        head:
        while (true) {
            final Object g = generation;
            if (count < 0) {
                continue head;
            }

            if (!casDecrement()) {
                continue head;
            }

            index = count;
            if (resetCount()) {
                final Runnable command = barrierCommand;
                if (command != null)
                    command.run();
                generation = new Object();
                signalAll();
                return 0;
            }


            while (true) {
                concurrentLinkedQueue.offer(Thread.currentThread());
                LockSupport.park();
                if (g != generation) {
                    return index;
                }
            }
        }
    }

    private void signalAll() {
        while (!concurrentLinkedQueue.isEmpty()) {
            LockSupport.unpark(concurrentLinkedQueue.poll());
        }
    }

    private final boolean casDecrement() {
        return UNSAFE.compareAndSwapInt(this, countOffset, count, count - 1);
    }

    private final boolean resetCount() {
        return UNSAFE.compareAndSwapInt(this, countOffset, 0, parties);
    }

}
