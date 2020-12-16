package Concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * When we call signal on the object.
 * at that time the object that is waiting in waiting state will be move to the runnable state.
 * at the time of fair locking  the when we call signal on the object than that object move to runnable state.
 * or we can say move into runnable state of thread pool.so after thread scheduler picks one of the thred from thread pool and execute its execution.
 *
 *
 *In case of Fair locking...when calling wait() method on object.than at that time lock on the object get's released by thread thred
 * Thread goes into waiting state or we can say Blocked State.
 * so that other thread from thread pool gets chance to execute.in Fair locking case the thread which will be on the top
 * or wer can say the thread which will submitted first for execute by scheduler will get selected.
 * 
 * so the other thread who willing to acquier the lock will acquier the lock on the object which was acquier by thread which call wait().
 * oce thread call signal() or we call notify() than thread which will be in Blocked State or Waiting state move to the Runnable State or we can say to the Thread Pool.
 * 
 */
public class FairLockingReentrantLock {
	public static void main(String[] args) throws InterruptedException {
		final FairtRunner r = new FairtRunner();
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
		
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				try {
					r.ThirdThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable(){
			public void run(){
				try {
					r.FourthThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		Thread.currentThread().sleep(100);
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		r.finished();
	}
	
}




class FairtRunner{
	private int count=0;
	private Lock lock = (Lock) new ReentrantLock(true); // By passing constructor argument as true to make fair lock
	private Condition cond = lock.newCondition();
	
	private void increment(){
		for(int i=0;i<100;i++){
			count++;
		}
	}
	
	
	public void firstThread()throws Exception{
		try{
			System.out.println("try to acuier Lock: First Thread");
			lock.lock();
			System.out.println("Lock acuiquer by First Thread");
			System.out.println("Waiting....");
			cond.await();
			System.out.println("Woken Up!");
			try{
				increment();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			System.out.println("Lock Released by : First Thread");
			lock.unlock();
		}
		
	}
	
	
	public void secondThread()throws Exception{
		try{
			System.out.println("try to acuier Lock: Second Thread");
			lock.lock();
			Thread.sleep(1000);
			System.out.println("Lock acuiquer by Second Thread");
			System.out.println("Press the return Key");
			new Scanner(System.in);
			System.out.println("Got return key");
			cond.signalAll();					///Same as notify in Intrinsic lock
			increment();
			Thread.currentThread().sleep(10000);
			System.out.println("Increment Complete by Second Thread");
		}finally{
			System.out.println("Lock Released by : Second Thread");
			lock.unlock();
		}
		
	}
	
	public void ThirdThread()throws Exception{
		try{
			System.out.println("try to acuier Lock: Third Thread");
			Thread.sleep(1000);
			lock.lock();
			System.out.println("Lock acuiquer by Third Thread");
			increment();
			cond.signalAll();
			Thread.currentThread().sleep(10000);
			
		}finally{
			System.out.println("Lock Released by : Third Thread");
			lock.unlock();
		}
	
	}
	
	public void FourthThread()throws Exception{
		try{
			Thread.sleep(1000);
			System.out.println("try to acuier Lock: Fourth Thread");
			lock.lock();
			System.out.println("Lock acuiquer by Fourth Thread : Fourth Thread");
			increment();
			cond.signalAll();
			Thread.currentThread().sleep(10000);

		}finally{
			System.out.println("Lock Released by : Fourth Thread");
			lock.unlock();
		}
		
	}
	
	public void finished(){
		System.out.println("Count"+count);
	}
	
	
}