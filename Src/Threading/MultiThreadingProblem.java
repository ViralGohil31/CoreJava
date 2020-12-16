package Threading;


/**
 * 
 * @author Viral
 *
 */
/*
 * Problem : Suppose there are three Thread .
 * Thread1 : Prints 1,1,1,1,1, ... n
 * Thread2 : Prints 2,2,2,2,2,.....n
 * Thread3 : prints 3,3,3,3,3,.....n
 * 
 * Write a program in such a way that it will prints 1,2,3,1,2,3,1,2,3 so on.
 */
/**
 * 
 * In this i have created three different Problem object for each thread so that each thread have there own object.
 * and i have created static variable thread1 ,thread 2 and thread3 so that depending upon this value thread are executing.
 *
 */
public class MultiThreadingProblem {
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		Thread t1 = new Thread(p);
		t1.setName("Thread1");
		Thread t2 = new Thread(new Problem1());
		t2.setName("Thread2");
		Thread t3 = new Thread(new Problem1());
		t3.setName("Thread3");
		t1.start();
		t2.start();
		t3.start();
	}
	
}



class Problem1 implements Runnable{
	public static boolean thread1 = false;
	public static boolean thread2 = false;
	public static boolean thread3 = false;
	
	@Override
	public void run() {
		synchronized (this) {
			while(true){
				if("Thread1".equalsIgnoreCase(Thread.currentThread().getName()) && !thread1){
					System.out.print("1,");
					thread1= true;
				}
				if("Thread2".equalsIgnoreCase(Thread.currentThread().getName()) && thread1 && !thread2){
					System.out.print("2,");
					thread2 = true;
					thread3 = false;
				}
				
				if("Thread3".equalsIgnoreCase(Thread.currentThread().getName()) && thread2 && !thread3){
					System.out.println("3");
					thread3 = true;
					thread1 = false;
					thread2 = false;
					
				}
			}
		}
		
	}
	
}
