import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;



public class Test {
	public static void main(String args[]){
	Map<String,String> a = new HashMap<String,String>();
	a.put("1", "1");
	a.put("1", "2");
	System.out.println(a.get("1"));
	a = new Hashtable<String,String>();
	a.put("1", "1");
	a.put("1", "2");
	System.out.println(a.get("1"));
	}
}
