package Concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiProducerConsumerUsingThreadPool {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
		ExecutorService executorProducer = Executors.newFixedThreadPool(2);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0;i<10;i++){
			Runnable r = new Producer(q,""+i);
			executorProducer.execute(r);
			Thread.sleep(100);
			Runnable c = new Consumer(q,""+i);
			executor.execute(c);
		}
		
		
		
		
		for(int i=0;i<10;i++){
			
		}
		
	}
}
