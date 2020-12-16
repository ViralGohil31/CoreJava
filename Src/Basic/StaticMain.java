package Basic;


public class StaticMain {
	public static void main(String[] args) {
		A b = new A();
	}
}


class A{
	static{
		System.out.println("static A");
		A a = new B();
		a.run();
	}
	
	public void run(){
		System.out.println("A");
	}
}


class B extends A{
	static{
		System.out.println("static B");
	}
	
	public void run(){
		System.out.println("B");
	}
}