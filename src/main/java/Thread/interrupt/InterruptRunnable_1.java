package Thread.interrupt;

/**
 * 试验中断线程
 * 
 * @author panqian
 * @date 2016年12月21日 下午7:05:28
 */
public class InterruptRunnable_1 implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("我在外面。。。。");
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("我走了。。。。");
				break;
			}
		}
	}

}