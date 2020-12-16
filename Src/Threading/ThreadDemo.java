package Threading;

public class ThreadDemo {
	public static void main(String args[]){
		abc a1 = new abc();
		
		/*Runnable r = new Thread(a1);
		r.run();
		Runnable r2 = new Thread(a1);
		r2.run();*/
		Thread a =new Thread(a1);
		a.setName("Thread1");
		Thread b = new Thread(a1);
		b.setName("Thread2");
		a.start();
		b.start();
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				
				System.out.println("Threadc is Running");
			}
		};
		
		//Thread c = new Thread(r);
		Thread c = new Thread(()->System.out.println("ThreadC is Running"));
		c.start();
		
		
	}
}



class abc implements Runnable{
	//bcd b  = new bcd();
	@Override
	public void run() {
		synchronized (this){
			bcd b  = new bcd();
			for (int i = 0; i <200; i++) {
				System.out.println(Thread.currentThread().getName()+" "+ i);
				b.getValue();
			
			}
		
		}
	}
}




class bcd{
	int a=0;
	public void getValue(){
		System.out.println(Thread.currentThread().getName()+" "+a++);
		
	}
}