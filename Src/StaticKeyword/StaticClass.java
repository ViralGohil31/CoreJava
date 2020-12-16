package StaticKeyword;

public class StaticClass {
	public static void main(String[] args) {
		StaticAccess st = new Hello();
		st.print();
		st.nonStaticPrint();
	}
}





class StaticAccess{
	public static void print(){
		System.out.println("Static Method :Static Access");
	}
	
	public  void nonStaticPrint(){
		System.out.println("Static Method :Static Access");
	}
}

class Hello extends StaticAccess{
	public static void print(){
		System.out.println(" Static Method :Hello");
	}
	

	public  void nonStaticPrint(){
		System.out.println("Overriden NonStatic Method :Static Access");
	}
}