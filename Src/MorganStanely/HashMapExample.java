package MorganStanely;

import java.util.*;
public class HashMapExample {
	public static void main(String[] args) {
		HashMap<String, String> m = new HashMap<String,String>();
		String a = new String("A"); 
		//m.put("A", 12);
		//m.put("A", 13);
		m.put(a, "14");
		
		put(m);
		System.out.println("Size of Map is "+m.size()+" element of A "+m.get(12));
	}
	
	public static void put(Map p) {
		p.put(12, 12);
	}
}
