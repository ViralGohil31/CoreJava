package Basic;

public class StaticConstructorInstanceVari {
	public static void main(String[] args) {
		P p = new C();
	}
	
	
}



class P{
	{
		System.out.println("Parent Instance block");
	}
	int p=10;
	static{
		System.out.println("Parent static block");
	}
	
	P(){
		System.out.println("Parent Constructor");
	}
	
	
}

class C extends P{
	{
		System.out.println("Child Instance block");
	}
	
	C(){
		System.out.println("Child Constructor");
	}
	static{
		System.out.println("Child static block");
	}
}