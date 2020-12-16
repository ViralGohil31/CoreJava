package CollectionExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		ListIterator<Integer> itr = l.listIterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.add(12);
		}
		
		ListIterator<Integer> it = l.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
