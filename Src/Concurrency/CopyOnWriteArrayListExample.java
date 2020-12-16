package Concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		
	
		ListIterator<Integer> itr = a.listIterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
			System.out.println(itr.next());
			
		}
		
		ListIterator<Integer> it = a.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}






