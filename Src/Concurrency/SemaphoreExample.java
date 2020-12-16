package Concurrency;

import java.util.concurrent.Semaphore;

/*
 * Here Semaphore is actually used to restrict the number of threads to access the shared resource.shared resource will be anything.
 * it could be printer,file or anything.
 * Here we have declare maximum of 1 thread is allow to get Permit.and access the sharead resource.
 * 
 */
public class SemaphoreExample {
	static Semaphore semaphore  = new Semaphore(1);
	
	static class MyThread extends Thread{
		public void run(){
			try{
				System.out.println("try to acquiring  Lock "+Thread.currentThread().getName());
				semaphore.acquire();
				System.out.println(" got Permit "+Thread.currentThread().getName());
				try{
					
						System.out.println("Performing Operation  Available Semaphore Permits "+semaphore.availablePermits());
						Thread.sleep(1000);
					
					
				}finally{
					System.out.println("Releasing lock "+Thread.currentThread().getName());
					semaphore.release();
					System.out.println("Available Permits"+semaphore.availablePermits());
				}
				
			}catch(Exception  e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		System.out.println("Total Available Permits"+semaphore.availablePermits());
		MyThread t1  = new MyThread();
		t1.setName("Thread1");
		
		MyThread t2  = new MyThread();
		t2.setName("Thread2");
		
		MyThread t3  = new MyThread();
		t3.setName("Thread3");
		
		MyThread t4  = new MyThread();
		t4.setName("Thread4");
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
