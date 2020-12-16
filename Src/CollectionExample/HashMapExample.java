package CollectionExample;

import java.util.HashMap;
import java.util.Iterator;



/**
 * 
 * @author viral
 *
 *  if equals() method is not override than the same object will inserted in the same bucket, because it will not able to compare the
 *  the value of both the object
 *   
 *   if hashCode() method is not override than it will store the all the values whether it is conatining the duplicate key that also will get store it into other bucket.
 *   
 */
public class HashMapExample {
	public static void main(String[] args) {
		HashMap<Person,String> m = new HashMap<Person,String>();
		Person p = new Person(3);
		m.put(p, "123");
		m.put(new Person(1), "124");
		m.put(new Person(3), "125");
		m.put(new Person(3), "126");
		m.put(new Person(3), "127");
		m.put(new Person(3), "127");
		
		System.out.println(m.get(p));
		
		/*Iterator<Person> itr = m.keySet().iterator();
		while(itr.hasNext()) {
			System.out.println(m.get(itr.next()));
		}*/
	}
}

class Person{
	private String gender;
	private int height;
	private int weight;
	private int personId;
	
	Person(int personId){
		this.personId = personId;
	}
	
	/*public boolean equals(Person o) {
		System.out.println("Person");
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("Object");
		if(this ==o) {
			return true;
		}
		if(o instanceof Person) {
			Person p = (Person)o;
			if(this.personId==p.personId) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
*/
	@Override
	public int hashCode() {
		return personId;
	}
	
}