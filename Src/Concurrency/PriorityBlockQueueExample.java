package Concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockQueueExample {
	public static void main(String[] args)throws Exception {
		System.out.println("Hi");
		BlockingQueue<Integer> pQueue = new PriorityBlockingQueue<Integer>();
		BlockingQueue<Integer> aQueue = new ArrayBlockingQueue<Integer>(2);
		Thread t1 = new Thread(new ProducerEx(pQueue,aQueue));
		Thread t2 = new Thread(new ConsumerEx(pQueue,aQueue));
		t1.start();
		
		Thread.currentThread().sleep(100);
		t2.start();
	}
	
}


class ProducerEx implements Runnable{

	BlockingQueue<Integer> queue;
	BlockingQueue<Integer> aqueue;
	
	ProducerEx(BlockingQueue<Integer> queue,BlockingQueue<Integer> aqueue){
		this.queue = queue;
		this.aqueue = aqueue;;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Put 20");queue.put(20);
			System.out.println("Put 19");queue.put(19);
			System.out.println("Put 18");queue.put(18);
			System.out.println("Put 17");queue.put(17);
			System.out.println("Put 14");queue.put(14);
			System.out.println("Put 15");queue.put(15);
			System.out.println("Put 16");queue.put(16);
			
			
			aqueue.put(1);
			System.out.println(aqueue.offer(2));;
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}



class ConsumerEx implements Runnable{

	BlockingQueue<Integer> queue;
	BlockingQueue<Integer> aqueue;
	
	ConsumerEx(BlockingQueue<Integer> queue,BlockingQueue<Integer> aqueue){
		this.queue = queue;
		this.aqueue = aqueue;
	}
	
	@Override
	public void run() {
	
		try {
			
			System.out.println("take"+queue.take());
			System.out.println("take"+queue.take());
			System.out.println("take"+queue.take());
			System.out.println("take"+queue.take());
			System.out.println("take"+queue.take());
			System.out.println("take"+queue.take());
			System.out.println("take"+queue.take());
			System.out.println("Last take"+queue.poll());
			
			System.out.println("Array take "+aqueue.take());
			System.out.println("Array take "+aqueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}