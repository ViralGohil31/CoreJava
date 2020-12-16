package OOP;

public class InstanceOFExample {
	public static void main(String[] args) {
		Parent p = new Parent();
		Parent pr = new Child();
		if(p instanceof Parent){
			System.out.println("p is instance of Parent");
		}
		if(p instanceof Child){
			System.out.println("p is instance of Child");
		}
		
		
		if(pr instanceof Parent){
			System.out.println("pr is instance of Parent");
		}
		if(pr instanceof Child){
			System.out.println("pr is instance of Child");
		}
	}
}





class Parent{
}

class Child extends Parent{	
}