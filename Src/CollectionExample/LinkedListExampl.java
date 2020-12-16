package CollectionExample;

import java.util.*;

public class LinkedListExampl {
	public static void main(String[] args) {
		List<String> ll = new LinkedList<String>();
		ll.add("Hello");
		ll.add("Hi");
		ll.add("Bye");
		
		Iterator<String> i = ll.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		Stack<String> st = (Stack<String>) ll;
		
	}
}
