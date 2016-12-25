package Thread.lock.bean;

/**
 * 测试线程局部变量,每个线程有自己的局部变量，与其他线程的同名变量不相干扰
 * 
 * @author panqian
 * @date 2016年12月25日 下午2:35:43
 */
public class Bank_3 extends Bank {

	private static ThreadLocal<Integer> thread = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return 1;
		}

	};

	@Override
	public void consume() {
		int integer = thread.get();
		thread.set(++integer);
		System.out.println(Thread.currentThread().getName() + ": " + thread.get());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
