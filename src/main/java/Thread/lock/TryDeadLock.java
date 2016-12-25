package Thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * trylock的应用  拿不到锁直接return 避免死锁的情况
 *
 * @author panqian
 * @date 2016年12月24日 下午8:14:08
 */
public class TryDeadLock implements Runnable {

    public int flag = 0;

    static ReentrantLock o1 = new ReentrantLock();
    static ReentrantLock o2 = new ReentrantLock();

    @Override
    public void run() {

        if (flag == 0) {
            if (o1.tryLock()) {
                System.out.println(Thread.currentThread().getName()+": o1 lock");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (o2.tryLock()) {
                    System.out.println(Thread.currentThread().getName()+": o2 lock");
                } else {
                    System.out.println(Thread.currentThread().getName()+": return");
                    return;
                }

            } else {
                System.out.println(Thread.currentThread().getName()+": return");
                return;
            }


        }

    else

    {
        if (o2.tryLock()) {
            System.out.println(Thread.currentThread().getName()+": o2 lock");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (o1.tryLock()) {
                System.out.println(Thread.currentThread().getName()+": o1 lock");
            } else {
                System.out.println(Thread.currentThread().getName()+": return");
                return;
            }
        } else {
            System.out.println(Thread.currentThread().getName()+": return");
            return;
        }
    }

}

}