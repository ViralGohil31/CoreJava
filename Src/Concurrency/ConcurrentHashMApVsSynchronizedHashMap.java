package Concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Synchronized map will throw Concurrent Modification Exception while Concurrent HashMap will not throw Concurrent Modification.
 *
 */
public class ConcurrentHashMApVsSynchronizedHashMap {
	public static void main(String[] args) throws InterruptedException {
		Map<String,String> m = new HashMap<String, String>();
		//Map<String,String> map = Collections.synchronizedMap(m);
		
		
		Map<String,String> map = new ConcurrentHashMap<String, String>();
		final ThreadRun t = new ThreadRun(map);
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t.perform();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.iterate();
				
			}
		});
		
		t1.start();
		//Thread.sleep(50);
		t2.start();
	}
}

class ThreadRun{
	Map<String,String> map = null;
	ThreadRun(Map<String,String> map){
		this.map = map;
	}
	public void perform() throws InterruptedException{

		for(int i=0;i<10000;i++){
			map.put(null, null);
			map.put("Viral"+i, "PEG");
			System.out.println("Put"+i);
			//Thread.sleep(10);
		}
	}
	
	
	
	public void iterate(){
		try{
			Thread.sleep(10);
			Iterator<Map.Entry<String,String>> itr  = map.entrySet().iterator();
			
			while(itr.hasNext()){
				Map.Entry<String, String> v = itr.next();
				System.out.println(v.getKey()+" Value"+v.getValue());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
