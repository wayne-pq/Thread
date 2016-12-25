package Thread.interrupt;

/**
 * 试验中断线程 
 * 1. 当这个线程刚好或即将被阻塞在wait，join，sleep方法的时候，调用 interrupt（非静态方法）会引起这个线程的interrupt状态被清空（设为false），并且前者三个方法会抛出InterruptedException。
 *	除此之外（这个线程不处于wait，join，sleep方法），这个线程的interrupt状态会被设置（设为true）。
 * 2. 调用interrupt(静态方法)会返回当前线程的interrupt状态（true或false），并把当前线程的interrupt状态清空（设为false）。
 *  注意：这个是个静态方法，并且返回的是当前线程状态，并不一定是调用者的线程状态。
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class InterruptRunnable_2 implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("我在外面。。。。");
			try {
				Thread.currentThread().sleep(2000);

			} catch (InterruptedException e) {
				System.out.println("捕捉到InterruptedException");
				//非静态方法interrupt碰到线程阻塞     sleep()抛异常   清空中断状态   中断状态设为false
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("我走了。。。。");
				}
				//非静态方法interrupt未碰到线程阻塞     中断状态设为true
				Thread.currentThread().interrupt();
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("我还是走了。。。。");
				}
				//静态方法interrupt清空中断状态  中断状态设为false
				//因为最后状态为false 根据第四个原理   下次循环不再受中断影响   不再抛出异常
				Thread.interrupted();
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("我真的走了。。。。");
				}

			}

		}
	}

}