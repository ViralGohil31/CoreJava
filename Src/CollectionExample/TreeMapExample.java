package CollectionExample;

import java.util.Iterator;
import java.util.TreeMap;

 class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		tree.put("3", "viral");
		tree.put("2", "Rajendra");
		tree.put("1", "Nitin");
		
		Iterator<String> iterator = tree.keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			System.out.println("Key :"+key+" Value :"+tree.get(key));
			
		}
		
		
	}
}
