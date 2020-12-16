package Concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	public static void main(String[] args) throws InterruptedException {
		final Runner r = new Runner();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					r.firstThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					r.secondThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		r.finished();
	}
	
}




class Runner{
	private int count=0;
	private Lock lock = (Lock) new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void increment(){
		for(int i=0;i<100;i++){
			count++;
		}
	}
	
	
	public void firstThread()throws Exception{
		try{
			lock.lock();
			System.out.println("Waiting....");
			cond.await();
			System.out.println("Woken Up!");
			try{
				increment();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			lock.unlock();
		}
	}
	
	
	public void secondThread()throws Exception{
		try{
			Thread.sleep(1000);
			lock.lock();
			System.out.println("Press the return Key");
			Scanner sc = new Scanner(System.in);
			sc.next();
			System.out.println("Got return key");
			cond.signal();					///Same as notify in Intrinsic lock
			increment();
			Thread.currentThread().sleep(10000);
			System.out.println("Increment Complete by Second Thread");
		}finally{
			lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println("Count"+count);
	}
	
	
}