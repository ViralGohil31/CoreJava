package Threading;

public class SynchronizedExample {
	public static void main(String args[]){
	Sync s = new Sync();
	Thread t1 = new Thread(s);
	Thread t2 = new Thread(s);
	Thread t3 = new Thread(s);
	Thread t4 = new Thread(s);
	Thread t5 = new Thread(s);
	t1.setName("Thread1");
	t2.setName("Thread2");
	t3.setName("Thread3");
	t4.setName("Thread4");
	t5.setName("Thread5");
	t1.setPriority(10);
	t2.setPriority(7);
	t3.setPriority(5);
	t4.setPriority(3);
	t5.setPriority(1);
	t5.start();
	t4.start();
	t3.start();
	t2.start();
	t1.start();
	}
}

class Sync implements Runnable{

	public void run(){
		System.out.println("Start"+Thread.currentThread().getName());
		try {
			getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void getName()throws Exception{
		System.out.println("Inside getName()"+Thread.currentThread().getName());
		synchronized(this){
			System.out.println("Sleep"+Thread.currentThread().getName());
		Thread.currentThread().sleep(10000);
		System.out.println("End"+Thread.currentThread().getName());
		}
	}
}
