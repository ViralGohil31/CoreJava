package Java8Features;

public class StaticMethodInterface implements D{

	public static void print(){
		System.out.println("class print");
		
	}
	
	public static void main(String[] args) {
		StaticMethodInterface s = new StaticMethodInterface();
		s.print();
		D.print();
	}
}




interface D{
	static void print(){
		System.out.println("Static interface method");
	}
}