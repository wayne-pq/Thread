package Thread.lock.bean;

public class Bank_2 extends Bank {

	int Num;

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	/**
	 * 消费
	 */
	@Override
	public synchronized void consume() {

		while (Num <= 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " 线程进入等待");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Num--;
		System.out.println(Thread.currentThread().getName() + " 消费了,还剩下金额" + Num);

	}

	/**
	 * 充值
	 */
	@Override
	public synchronized void topUp() {
		if (Num >= 0) {
			Num++;
			System.out.println(Thread.currentThread().getName() + " 充值了,还剩下金额" + Num);
			notifyAll();
		}
	}

}
