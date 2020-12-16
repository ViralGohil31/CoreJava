package OOP;

public class ConstructorDemo {
	public static void main(String[] args) {
		new House("Hello");
	}
}



class Building{
	Building() {
		System.out.print("b ");
	}
	Building(String name){
		this();
		System.out.println("b1");
		
	}
}

class House extends Building{
	House(){
		System.out.println("h1");
	}
	House(String name){
		this();
		System.out.println("h");
	}
}