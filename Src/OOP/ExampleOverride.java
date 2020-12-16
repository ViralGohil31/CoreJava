package OOP;

public class ExampleOverride {
	public static void main(String[] args) {
		//A b = new B();
		B b = new B();
		b.print();
		
	}
	
}





class A{
	 void print(){
		System.out.println("ABC");
	}
	
	public void println(){
		System.out.println("ABC");
	}
	
	
	public void say(){
		this.print();
	}
}




class B extends A{
	public void print(){
		System.out.print("BCD");
	}
}