package multithreadingtest;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ThreadLocal threadLocal = new ThreadLocal();
		System.out.println(threadLocal.get()); //null
		threadLocal.set("Pratyush");
		System.out.println(threadLocal.get()); //Pratyush
		threadLocal.remove();
		System.out.println(threadLocal.get()); //null

	}

}
