package Thread.test.callable;

import Thread.callable.UUIDCounter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class UUIDCounterThread_1 {

	public static void main(String[] str) {


		UUIDCounter uuidCounter = new UUIDCounter();

		FutureTask<String> futureTask = new FutureTask<String>(uuidCounter);
		Thread thread = new Thread(futureTask);
		thread.start();

		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}


	}
}
