package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
	public static void main(String[] args) {
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		
		Reader  reader = new Reader(readWriteLock);
		Writer writer = new Writer(readWriteLock);
		Thread r = new Thread(reader);
		Thread r1 = new Thread(reader);
		Thread r2 = new Thread(reader);
		Thread r3 = new Thread(reader);
		Thread w = new Thread(writer);
		Thread w1 = new Thread(writer);
		r.setName("Reader1");
		r1.setName("Reader2");
		r2.setName("Reader3");
		r3.setName("Reader4");
		w.setName("Writer1");
		w1.setName("Writer2");
		w.start();
		r.start();
		r1.start();
		w1.start();
		r2.start();
		r3.start();
		
	}
}



class Reader implements Runnable{
	ReadWriteLock lock;
	Reader(ReadWriteLock lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		System.out.println("Reader Thread Waiting to get Lock"+ Thread.currentThread().getName());
		lock.readLock().lock();
		System.out.println("Reader get Lock "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Reader Thread Completed "+Thread.currentThread().getName());
		lock.readLock().unlock();
		
	}
	
}


class Writer implements Runnable{
	
	ReadWriteLock lock;
	Writer(ReadWriteLock lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		System.out.println("Writer Thread is waiting to get Lock "+Thread.currentThread().getName());
		lock.writeLock().lock();
		System.out.println("Writer Lock "+Thread.currentThread().getName());
		try {
			Thread.sleep(9000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Writer Thread Completed "+Thread.currentThread().getName());
		lock.writeLock().unlock();
		
	}
	
}