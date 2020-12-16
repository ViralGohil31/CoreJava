package Threading;

public class MultiThread {
	public static Boolean thread1 = false;
	public static Boolean thread2 = false;
	
	public static void main(String[] args) {
		
		ThreadDemo1 td1 = new ThreadDemo1(thread1,thread2);
		Thread t1 = new Thread(td1);
		ThreadDemo2 td2 = new ThreadDemo2(thread1,thread2);
		Thread t2 = new Thread(td2);
		t1.run();
		t2.run();
	}
}


class ThreadDemo1 implements Runnable{
	public Boolean thread1;
	public Boolean thread2;
	
	ThreadDemo1(boolean thread1,boolean thread2){
		this.thread1 = thread1;
		this.thread2 = thread2;
	}
	
	@Override
	public void run(){
		synchronized (thread2) {
			System.out.println("Thread1");
			thread1 = true;
			thread2.notifyAll();
			
		}
		
	}
}

class ThreadDemo2 implements Runnable{
	public Boolean thread1;
	public Boolean thread2;
	
	ThreadDemo2(boolean thread1,boolean thread2){
		this.thread1 = thread1;
		this.thread2 = thread2;
	}
	@Override
	public void run(){
		try{
		synchronized (thread1) {
			if(!thread1)
				thread2.wait();
				System.out.println("Thread2");
			}
		}catch(Exception e){
			
		}
		
	}

}