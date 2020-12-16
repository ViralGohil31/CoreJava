package Threading;
/*
 * Singletone Class is not a Thread Safe.When more than one thread is going to access the singletone Object instance .
 * than both will be create there own copy.
 * 
 */

public class SingletoneMultiThreaded {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		t1.start();
		t2.start();
		
		//t1.start();
		//t2.start();
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		synchronized (this) {
			Values a1=null;
			try {
				a1 = Singletone.getInstance();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(a1.a);
		}
		
		
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		synchronized (this) {
			Values a1=null;
			try {
				a1 = Singletone.getInstance();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(a1.a);
		}
	}
	
}



class Singletone{
	//private static Values a=new Values();
	private static Values a = null;
	private Singletone(){
	}
	public  static Values getInstance() throws InterruptedException{
		if(a== null){
		synchronized (Singletone.class) {
			if(a==null){						//Double checking i n multi threading
				a= new Values();
			}else return a;
			}
			return a;
		}else{
			return a;
		}
		
	}
	
}


class Values{
	int a ;
	static int i=0;
	public Values() throws InterruptedException {
		System.out.println("Creating Values");
		Thread.currentThread().sleep(100);
		a= ++i;
	}
}
