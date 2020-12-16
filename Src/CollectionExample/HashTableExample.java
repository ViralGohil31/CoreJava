package CollectionExample;

import java.util.Dictionary;
import java.util.Hashtable;

public class HashTableExample {
	public static void main(String[] args) {
		Dictionary<String, String> map = new Hashtable<String,String>();
		//map.put(null, "VIRAL");
		try{
		map.put("2", "RAJ");
		map.put("1", "RAJENDRA");
		
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}

