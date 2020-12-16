package Threading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblemEx {
	public static void main(String[] args) {
		Produce p = new Produce();
		Consume c = new Consume(p);
		p.start();
		c.start();
	}
}

class Produce extends Thread{
	List<String> l = new ArrayList<String>();
	public  void run(){
		try{
			
				while(true){
					synchronized (this) {
					if(l.isEmpty()){
						putMessage();
						notify();
					}else{
						wait();
					}
				}
				
			}
		}catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
	
	
	public void putMessage(){
		//System.out.println("Produce");
		for(int i=0;i<5;i++){
			System.out.println("Producer Produce"+i);
			l.add(""+i);
		}
	}
	
	
	public synchronized void getMessage(){
		System.out.println("consume "+l.remove(0)+" now size"+l.size());
	}
	
}

class Consume extends Thread{
	Produce p;
	Consume(Produce p){
		this.p = p;
	}
	
	public  void run(){
		try{
			while(true){
				synchronized (p) {
					if(p.l.isEmpty()){
						p.wait();
					}else{
						p.getMessage();
						p.notify();
					}
	
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}