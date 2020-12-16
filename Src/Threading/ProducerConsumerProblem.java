package Threading;
import java.util.ArrayList;
import java.util.List;


public class ProducerConsumerProblem {
	public static void main(String[] args) {
		//List<Integer>  list = Collections.synchronizedList(new ArrayList<Integer>());
		List<Integer>  list = new ArrayList<Integer>();
		Producer p = new Producer(list);
		Consumer c = new Consumer(list);
		Thread t1 = new Thread(p);
		t1.setName("Producer");
		Thread t2 = new Thread(c);
		t2.setName("Consumer");
		t1.start();
		t2.start();
		
		
	}
}




class Producer implements Runnable{
	List<Integer> obj;
	
	public Producer(List<Integer> obj){
		this.obj = obj;
	}
	
	@Override
	public void run() {
		try{
			synchronized (obj) {
				for(;;){
					if(obj.isEmpty()){
						Produce(obj);
						obj.notify();
					}else
						obj.wait();
				}
			}
		}catch(Exception e){
			System.out.println("Producer "+e);
		}
	}
		
	public void Produce(List<Integer> obj){
		
				System.out.println(Thread.currentThread().getName()+" Produce "+obj.add(1));
			
	}
}

class Consumer implements Runnable{
List<Integer> obj;
	
	public Consumer(List<Integer> obj){
		this.obj = obj;
	}
	
	@Override
	public void run() {
		try{
			synchronized (obj) {
				for(;;){
				if(!obj.isEmpty()){
					consume(obj);
					obj.notify();
				}else{
					obj.wait();
				}
			}
			}
			
		}catch(Exception e){
			System.out.println("Consumer "+e);
		}
		
		
	}
	
	
	public void consume(List<Integer> obj){
		
			System.out.println(Thread.currentThread().getName()+" "+obj.remove(0));
	}
}