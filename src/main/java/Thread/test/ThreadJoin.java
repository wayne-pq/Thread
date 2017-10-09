package Thread.test;

/**
 * thread.join() 方法  ，让其他线程临时加入。
 * Waits for this thread to die.   等待这个线程死亡。
 */
public class ThreadJoin {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                for (int i = 0; i < 50; i++) {
                    System.out.print(i);
                }
            }
        };

        Thread A = new Thread(runnable);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("B 开始等待 A");
                    A.join();
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + " start.");
            }
        };

        Thread B = new Thread(runnable1);

        B.start();
        A.start();

//        thread.start();

    }
}
