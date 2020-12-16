package OOP;

public class AbstaractDemo {
	public static void main(String[] args) {
		Animal2 a = new Cat2();
		System.out.println(a.makeNoise()); //Dog class of makeNoise called
		System.out.println(a.isNoisy());  // Cat class  isNoisy is called
	}
	
	
}

abstract class Animal2{
	public abstract String makeNoise();
	protected abstract boolean isNoisy(); // protected can allow to override in child class
	public void getValue(){
		System.out.println("HIII");
	}
}

abstract class Dog2 extends Animal2{   //we required to marked this as abstract because it cannot implement al methods of Animal2 class
	public String makeNoise(){
		return "Dog Noise";
	}


/*	public boolean isNoisy() {
		// TODO Auto-generated method stub
		return false;
	}*/
}




class Cat2 extends Dog2{
	public  boolean isNoisy(){
		return true;
	}
}
