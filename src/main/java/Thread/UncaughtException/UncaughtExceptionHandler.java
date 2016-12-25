package Thread.UncaughtException;

/**
 * 异常处理器
 * 
 * @author panqian
 * @date 2016年12月22日 下午8:14:27
 */
public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("线程:" + t.getName() + " 抛出异常: " + e);
	}

}
