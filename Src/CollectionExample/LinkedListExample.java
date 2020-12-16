package CollectionExample;

import java.util.Iterator;

public class LinkedListExample {
	public static void main(String[] args) {
		java.util.LinkedList<String> ls = new java.util.LinkedList<String>();
		ls.add("Hi");
		
		Iterator<String> it = ls.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
	}
}
