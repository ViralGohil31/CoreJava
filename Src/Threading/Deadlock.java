package Threading;
/**
 * 
 * Deadlock describe the situation where two or more thread are blocked forever,waiting for each other.
 *	
 */
public class Deadlock {
	static class Friend{
		private final String name;
		public Friend(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
		
		public synchronized void bow(Friend f){
			System.out.println(Thread.currentThread().getName()+""+this.name+""+f.getName());
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f.bowBack(this);
		}
		
		public synchronized void bowBack(Friend e){
			System.out.println(""+this.name+""+e.getName());
		}
	}
	
	public static void main(String[] args) {
		Friend f = new Friend("Alpesh");
		Friend g = new Friend("Viral");
/*		new Thread(new Runnable(){
			public void run(){
				f.bow(g);
			}
		}).start();
		
		
		new Thread(new Runnable(){
			public void run(){
				g.bow(f);
			}
		}).start();*/
		
		Runnable r = ()->f.bow(g);
		Runnable p = ()->g.bow(f);
		new Thread(r).start();
		new Thread(p).start();
		
	}
}
