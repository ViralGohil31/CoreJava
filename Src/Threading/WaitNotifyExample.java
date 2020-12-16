package Threading;

/**
 * 
 * Wait  - it will released the current lock which acquirer on object. and allows other thread to acquier lock on same object. and wait untill other thread acquier the lock
 * 		   and released the lock.
 * 
 * notify - it will signal the thread which will be waiting for another thread . here second thread waiting for first thread to acquireer and signal to second thread to
 * 			start its excecution.
 * 			when notify signal it will call on particular object.than it will relaesed the current lock on that object on which held in sychronized block.and
 * 			waking up the one thread which will waiting for the same object lock.
 * 			
 * 			here object lock held on WaitNotify object by using synchronized(this).
 * 			this will refer the current object instance.
 *
 */
public class WaitNotifyExample {
	public static void main(String[] args)throws Exception {
		
		WaitNotify wn = new WaitNotify();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					wn.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					wn.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});


	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.print("End");
	}
}


class WaitNotify{
	
	private int count=0;
	public void firstThread()throws InterruptedException{
		try{
			synchronized (this) {
				System.out.println("First Thread Calling");
				increment();
				this.notify();
				System.out.println("After notifying...");
				Thread.sleep(10000);
				System.out.println("End First Thread Calling");
			}
		}catch(Exception e){
			
		}
	}
	
	
	private void increment(){
		for(int i=0;i<100;i++){
			count++;
		}
	}
	
	private void finished(){
		System.out.println(count);
	}
	
	public void secondThread()throws Exception{
		try{
			synchronized (this) {
				Thread.sleep(1000);
				System.out.println("Second Thread Calling");
				System.out.println("Waiting for first Thread to finished....");
				this.wait();
				finished();
				System.out.println("End Second Thread Calling");
			}
		}catch(Exception e){
			
		}
	}
	
}