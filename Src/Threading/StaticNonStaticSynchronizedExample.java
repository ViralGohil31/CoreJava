package Threading;


/*
 * If suppose that two Thread are accessing same instance of class and accessing Synchronized nonStatic and Synchronized Static Method 
 * than both can able to access  the method of same instance parrallely because one is holding Object lock(non static Sync Methods) while other is holding Class Level Locking(static Sync Methods) 
 * 
 */
public class StaticNonStaticSynchronizedExample {
	public static void main(String[] args){
		try {
			SyncNonSync s = new SyncNonSync();
			
			Thread t1 = new Thread(()->{
				try {
					s.get();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			Thread t2 = new Thread(()->s.put());
			t1.start();
			t2.start();
		}catch(Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}



class SyncNonSync{
	
	public synchronized void get() throws Exception {
		System.out.println("get");
		System.out.println(Thread.currentThread().getName()+" is Waiting");
		Thread.currentThread().sleep(10000);
		System.out.println(Thread.currentThread().getName()+" has Released the Lock");
	}
	
	
	
	public static synchronized void put() {
		System.out.println(Thread.currentThread().getName()+" static Method");
		System.out.println("put");
		
	}
	
}
