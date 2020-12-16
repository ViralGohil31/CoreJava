package Threading;

/*
 * In Synchronize method if if one thread is excecuting synchronized method ,than other thread will not allow to 
 *  execute any synchronized methods on same instance.
 *  here we are using three methods which is synchronized printThread1,2,3 . which is synchronized.
 *  if one thread is currently executing synchronized method like thread1 executing synchronized method printThread1 than no other thread thread 2 and thread3 will allow to execute any other method like printThread2 or printThread3 
 *  of same instance of DemoSync.
 *  because Synchronized method will lock the instance object.
 *  
 *  Synchronized define at method level and synchronized(this) will be same.it will lock same instance.
 *  
 */
public class SynchronizationMethodExample {
	public static void main(String[] args) {
		Syncn sync = new Syncn();
		Thread t1 = new Thread(sync);
		t1.setName("Thread1");
		Thread t2 = new Thread(sync);
		t2.setName("Thread2");
		Thread t3 = new Thread(sync);
		t3.setName("Thread3");
		Thread t4 = new Thread(sync);
		t4.setName("Thread4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Syncn implements Runnable{
	
	DemoSync d = new DemoSync();
	@Override
	public void run(){
		//System.out.println(Thread.currentThread().getName()+"In run");
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread1")){
			d.printThread1();
		}
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread2")){
			d.printThread2();
		}
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread3")){
			d.printThread3();
		}
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread4")){
			d.printThread4();
		}
	}
	
}



class DemoSync{
	public synchronized  void printThread1(){
		try{
				System.out.println(Thread.currentThread().getName()+"within Sync");
				Thread.currentThread().sleep(1000);
				System.out.println(Thread.currentThread().getName()+"Exiting Sync");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public synchronized  void printThread2(){
		try{
			System.out.println(Thread.currentThread().getName()+"within Sync");
			Thread.currentThread().sleep(1000);
			System.out.println(Thread.currentThread().getName()+"Exiting Sync");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public synchronized  void printThread3(){
		try{
			System.out.println(Thread.currentThread().getName()+"within Sync");
			Thread.currentThread().sleep(1000);
			System.out.println(Thread.currentThread().getName()+"Exiting Sync");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void printThread4(){
		try{
			synchronized(this){
				System.out.println(Thread.currentThread().getName()+"within Sync");
				Thread.currentThread().sleep(1000);
				System.out.println(Thread.currentThread().getName()+"Exiting Sync");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}