package Concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArrayListExample {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("10");
		a.add("12");
		a.add("13");	
		a.add("14");
		
		Iterator<String> itr = a.iterator();
		
		try{
			while(itr.hasNext()){
				System.out.println(itr.next());
				a.add("15");
			}
		}catch(Exception e){
			System.out.print(e);
		}
		
		List<String> b = new CopyOnWriteArrayList<String>();
		b.add("15");
		b.add("16");
		b.add("17");
		
		System.out.println("After adding into b list");
		Iterator<String> itrator = b.iterator();
		while(itrator.hasNext()){
			System.out.println(itrator.next());
			b.add("18");
		}
		System.out.println("After adding into b list");
		Iterator<String> it = b.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
		
		
	}
}
