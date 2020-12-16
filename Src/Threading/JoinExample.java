package Threading;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Join());
		t1.start();
		Thread.sleep(1000);
		t1.join();
	}
}



class Join implements Runnable{

	@Override
	public void run() {
		System.out.println("Completed");
		
	}
	
}