package Concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
	public static void main(String[] args) throws InterruptedException {
		RejectExeHandler rejHandler = new RejectExeHandler();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2),threadFactory,rejHandler);
		MonitorThread monitor  = new MonitorThread(executor, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		 // Submit Work to Threadpool
		for(int i=0;i<10;i++){
			executor.execute(new WorkerThread(i));
		}
		Thread.sleep(30000000);
		executor.shutdown();
		monitor.shutDown();
	}
}







class RejectExeHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString()+" is rejected");
	}
	
}



class MonitorThread implements Runnable{

	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;
	
	MonitorThread(ThreadPoolExecutor executor,int delay){
		this.executor = executor;
		this.seconds = delay;
	}
	
	public void shutDown(){
		this.run = false;
	}
	
	@Override
	public void run() {
		while(run){
			try{
			System.out.println(String.format("[monitor] [%d%d] Active: %d,  Completed: %d,Task: %d ,is shutdown :%s",this.executor.getPoolSize(),this.executor.getCorePoolSize(),this.executor.getActiveCount(),this.executor.getCompletedTaskCount(),this.executor.getTaskCount(),this.executor.isShutdown(),this.executor.isTerminated()));
			try{
				Thread.sleep(seconds*1000);
			}catch(InterruptedException exc){
				exc.printStackTrace();
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
}