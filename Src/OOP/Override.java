package OOP;

public class Override {
	public static void main(String[] args) {
		new Override().go();
	}
	
	public void go(){
		new Hound().bark();
		((Dog1)new Hound()).bark();
		//((Dog1)new Hound()).sniff();
	}
}


class Dog1{
	 void bark(){System.out.println("Dog bark");}
}


class Hound extends Dog1{
	 void sniff(){System.out.println("sniff");}
	public void bark(){
		super.bark();
		System.out.println("Hound bark");}
}