package Concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MultiProducerConsumerProblem {
	public static void main(String[] args)throws Exception {
		
		BlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>();
		for(int i=0;i<19;i++){
		Thread r =new Thread(new Producer(queue));
		r.setName(""+i);
		r.start();
		
		Thread.sleep(100);
		Thread c =new Thread(new Consumer(queue));
		c.setName(""+i);
		c.start();
		
		
		}
		
	}
}


class Producer implements Runnable{
	BlockingQueue<Integer> queue;
	String name;
	static int i;
	public Producer(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	
	public Producer(BlockingQueue<Integer> queue,String name){
		this.queue = queue;
		this.name = name;
	}
	

	@Override
	public void run() {
		try {
			
			System.out.println("Producer Thread "+(name!=null?name:Thread.currentThread().getName())+" Produce"+i);
			queue.put(i++);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}



class Consumer implements Runnable{
	BlockingQueue<Integer> queue;
	String name;
	
	public Consumer(BlockingQueue<Integer> queue,String name){
		this.queue = queue;
		this.name = name;
	}
	public Consumer(BlockingQueue<Integer> queue){
		this.queue = queue;
		this.name = name;
	}

	@Override
	public void run() {
	
		try {
			
				System.out.println("Consumer Thread "+(name!=null?name:Thread.currentThread().getName())+" Consumed "+queue.take());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}