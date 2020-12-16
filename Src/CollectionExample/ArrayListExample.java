package CollectionExample;
import java.util.*;
public class ArrayListExample {
	public static void main(String[] args) {
		
		List<Integer> a =new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		
		Iterator<Integer> itr = a.iterator();
		boolean valid=true;
		while(itr.hasNext()) {
			int b=itr.next();
			if(a.get(6)==b && valid) {
				itr.remove();
				valid=false;
			}
			
		}
		
		Iterator<Integer> it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
