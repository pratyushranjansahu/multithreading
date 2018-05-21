package multithreadingtest;

public class ThreadLocalInitialValueMethodDemo {

	public static void main(String[] args) {
		ThreadLocal threadLocal = new ThreadLocal() {
			protected Object initialValue() {
			return "bicky";
			}
			};
			System.out.println(threadLocal.get()); //bicky
			threadLocal.set("Pratyush");
			System.out.println(threadLocal.get()); //Pratyush
			threadLocal.remove();
			System.out.println(threadLocal.get()); //bicky
	}

}
