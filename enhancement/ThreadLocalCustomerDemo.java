package multithreadingtest;

public class ThreadLocalCustomerDemo {

	public static void main(String[] args) {
		CustomerThread c1 = new CustomerThread("CustomerThread - 1");
		CustomerThread c2 = new CustomerThread("CustomerThread - 2");
		CustomerThread c3 = new CustomerThread("CustomerThread - 3");
		CustomerThread c4 = new CustomerThread("CustomerThread - 4");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}

}

class CustomerThread extends Thread {
	static int custID = 0;
	private static ThreadLocal threadLocal = new ThreadLocal() {
		protected Integer initialValue() {
			return ++custID;
		}
	};

	CustomerThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " Executing with Customer ID:" + threadLocal.get());
	}
}
/*
 * In the Above Program for Every Customer Thread a Separate customerID will be
 * maintained by ThreadLocal Object.
 */