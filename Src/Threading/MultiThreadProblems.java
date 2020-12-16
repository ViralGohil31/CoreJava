package Threading;


/**
 * In Java Program with Thread will execute not linear way.means will not give gurantee that which thread will eecute successfully first,after second and so forth.
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiThreadProblems {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> a = new ArrayList<Integer>();
		
		
		Thread t1 = new Thread(new Multi(a,0));
		Thread t2 = new Thread(new Multi(a,10));
		Thread t3 = new Thread(new Multi(a,20));
		Thread t4 = new Thread(new Multi(a,30));
		
		t1.setName("Thread1");
		t2.setName("Thread2");
		t3.setName("Thread3");
		t4.setName("Thread4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		Thread.currentThread().join();
		Iterator<Integer> it = a.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	
	
	}





static class Multi implements Runnable{
	List<Integer> t;
	int i;
	private static  Monitor monitor = new Monitor();
	Multi(List<Integer> t,int i){
		this.t = t;
		this.i = i;
	}
	
	@Override
	public void run() {
		synchronized (monitor) {
		for(int j = i;j<i+10;j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.add(j);
		}
		}
	}
	
}
}

class Monitor{
	Monitor(){
		
	}
}