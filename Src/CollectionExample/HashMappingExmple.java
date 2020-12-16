package CollectionExample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMappingExmple {
	public static void main(String[] args) {
		HashMap<String, String> a = new HashMap<String, String>();
		a.put(null, "Viral");
		a.put("2", "Raj");
		a.put("3", "Nitin");
		a.put("3", "Vijay");
		a.put(null, "Ha");
		
		//Iterator Type1
		
		Set<Map.Entry<String,String>> entrySet = a.entrySet();
		Iterator<Map.Entry<String, String>> entrySetIterator = entrySet.iterator();
		while(entrySetIterator.hasNext()){
			Entry<String, String> entry = entrySetIterator.next();
			System.out.print("Key "+entry.getKey());
			System.out.println(" Value "+entry.getValue());
		}
		
		System.out.println("Next");
		//Iterator Type2
		//Iterator<String> keyiterator = a.keySet().iterator();
		Set<String> setMap = a.keySet();
		Iterator<String> keyiterator = setMap.iterator();
		while(keyiterator.hasNext()){
			String key = keyiterator.next();
			System.out.println("Key " + key +" Value "+a.get(key));
		}
		
		//Iterator Type3
		for(Entry<String, String> entry:a.entrySet()){
			System.out.println("Key "+entry.getKey()+" Value"+entry.getValue());
		}
		
		//Iterator Type4
		for(String key: a.keySet()){
			System.out.println("KEY "+key+" Value "+a.get(key) );
		}
		
	}
}
