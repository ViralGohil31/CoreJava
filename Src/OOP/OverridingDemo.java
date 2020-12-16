package OOP;

public class OverridingDemo {
	public static void main(String[] args) {
		Animal1 a = new Horse();
		System.out.println(a.getMessage()+" message"+a.message);
		a.makeNoise();
		
		Horse h = new Horse(); // Horse can access to all data members of Animal because Horse Inherited Animal
		h.saySomething();
		
		Animal1 a1 = new Horse();
		
		
	}
}


class Animal1{
	public String message = "Animal Messsage";
	
	public void makeNoise(){
		System.out.println("Animal make noise");
	}
	 
	public  String getMessage(){
		return message;
	}
	
	protected  void print(){
		System.out.println("Print Animal");
	}
	public void saySomething(){
		System.out.println("SOMETHING");
	}
	
	private final void say(){
		System.out.println("Say Final Animal");
	}
}



class Horse extends Animal1{
	public String message = "Horse Message";
	
	public void makeNoise(){
		
		System.out.println("Horse make Noise");
	} 
	
	public  String getMessage(){
		return message;
	}
	
	public void print(){
		System.out.println("print Horse");
	}
	
	public final void say(){
		System.out.println("Say Final Horse");
	}
	
	
	
}