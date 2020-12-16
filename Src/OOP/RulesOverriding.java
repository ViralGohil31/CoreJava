package OOP;

public class RulesOverriding {
	public static void main(String[] args) {
		Person p =new Student();
		p.getBehavior();
	}
}



class Person{
	  void getBehavior() {
		System.out.println("Person");
	}
}


class Student extends Person{
	
	 protected void getBehavior() {
		System.out.println("Student");
	}
	
}
