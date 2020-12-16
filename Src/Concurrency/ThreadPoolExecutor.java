package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0;i<=10;i++){
			Runnable r = new WorkerThread(i);
			executor.execute(r);
			
		}
	}
}



class WorkerThread implements Runnable{
	private int i;
	
	WorkerThread(int i){
		this.i= i;
	}
	
	@Override
	public void run(){
		
		try {
			System.out.println("Thread "+i);
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return ""+i;
	}
	
}


