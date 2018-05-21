package multithreadingtest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantVSSynchronized {

	public static void main(String[] args) {
		Display display = new Display();
		MyCustomThread myCustomThread = new MyCustomThread(display, "Pratyush");
		MyCustomThread myCustomThread2 = new MyCustomThread(display, "Manas");
		new Thread(myCustomThread).start();
		new Thread(myCustomThread2).start();

	}
	

}
class MyCustomThread implements Runnable {
	Display display;
	String name;

	MyCustomThread(Display display, String name) {
		this.display = display;
		this.name = name;
	}

	public void run() {
		display.wish(name);
	}
}
class Display {
	ReentrantLock reentrantLock = new ReentrantLock(true);
	public  void wish(String name) {
		reentrantLock.lock();
		for (int i = 0; i < 10; i++) {

			System.out.print("Good Morning : ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
		reentrantLock.unlock();
	}
}
