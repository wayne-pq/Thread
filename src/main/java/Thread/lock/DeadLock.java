package Thread.lock;

/**
 * 简单的死锁
 * @author panqian
 * @date 2016年12月24日 下午8:14:08
 */
public class DeadLock implements Runnable {

	public int flag = 0;
	static final Object o1 = new Object();
	static final Object o2 = new Object();

	@Override
	public void run() {

		if (flag == 0) {
			synchronized (o1) {
				System.out.println("o1 lock");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("o2 lock");
				}
			}
		} else {
			synchronized (o2) {
				System.out.println("o2 lock");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("o1 lock");
				}
			}
		}

	}

}