package Thread.UncaughtException;

/**
 * run方法不会抛出任何异常 所以主线程要捕获异常 需要一个异常处理器
 * 
 * @author panqian
 * @date 2016年12月22日 下午7:59:01
 */
public class UncaughtExceptionRunnable_1 implements Runnable {

	@Override
	public void run() {
		//故意制造算数异常
		System.out.println("算数：" + 5 / 0);
	}

}