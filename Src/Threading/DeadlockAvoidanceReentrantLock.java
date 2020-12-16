package Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockAvoidanceReentrantLock {
	static class Friend{
		
		private final String name;
		private final Lock lock = new ReentrantLock();
		
		public Friend(String name){
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean impendingBow(Friend bow){
			Boolean myLock = false;
			Boolean yourLock = false;
			try{
				myLock = lock.tryLock();
				yourLock = bow.lock.tryLock();
				
			}finally{
				if(!(myLock && yourLock)){
					if(myLock){
						lock.unlock();
					}
					if(yourLock){
						lock.unlock();
					}
				}
				
			}
			
			return myLock && yourLock;
			
		}
		
		public synchronized void bow(Friend f){
			System.out.println(Thread.currentThread().getName()+""+this.name+""+f.getName());
			if(impendingBow(f)){
				try{
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					f.bowBack(this);
				}finally{
					lock.unlock();
					f.lock.unlock();
				}
			}else{
				
			}
		}
		
		public synchronized void bowBack(Friend e){
			System.out.println(""+this.name+""+e.getName());
		}
	}
	
	public static void main(String[] args) {
		Friend f = new Friend("Alpesh");
		Friend g = new Friend("Viral");
		
		Runnable r = ()->f.bow(g);
		Runnable p = ()->g.bow(f);
		new Thread(r).start();
		new Thread(p).start();
		
	}
}
