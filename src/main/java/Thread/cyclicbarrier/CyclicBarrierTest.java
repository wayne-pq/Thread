package Thread.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CyclicBarrierTest {
    private static CyclicBarrierNoLock cyclicBarrier;

    public static void main(String[] args) {
        int num = 5;
        try {
            cyclicBarrier = new CyclicBarrierNoLock(num, () -> log.info("人到齐了"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < num; i++) {
            loop(num);
        }
    }

    private static void loop(int num) {
        for (int i = 0; i < num; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                }
                int index = cyclicBarrier.await();
                log.info(Thread.currentThread().getId() + ":" + index + ":我来了");
            });
            thread.setDaemon(false);
            thread.start();
        }
    }

}