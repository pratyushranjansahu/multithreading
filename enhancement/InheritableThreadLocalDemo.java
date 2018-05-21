package multithreadingtest;

class ParentThread extends Thread {
	public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal(){
		public Object childValue(Object p) {
			return "child";
		}
	};

	public void run() {
		inheritableThreadLocal.set("parent");
		System.out.println("Parent Thread --" + inheritableThreadLocal.get());
		ChildThread childThread = new ChildThread();
		childThread.start();
	}
}

class ChildThread extends Thread {
	public void run() {
		System.out.println("Child Thread --" + ParentThread.inheritableThreadLocal.get());
	}
}

public class InheritableThreadLocalDemo {

	public static void main(String[] args) {
		ParentThread parentThread = new ParentThread();
		parentThread.start();
	}

}
/*1)Parent Threads ThreadLocal Variables are by Default Not Available to the Child
Threads.
 2)If we want to Make Parent Threads Local Variables Available to Child Threads we
should go for InheritableThreadLocal Class.
 3)It is the Child Class of ThreadLocal Class.
 
4) By Default Child Thread Values are Same as Parent Thread Values but we can
Provide Customized Values for Child Threads by Overriding childValue().

5)In above program if InheritableThreadLocal class will not override childValue() , then the output should be 
Parent Thread --parent
Child Thread --parent
*/