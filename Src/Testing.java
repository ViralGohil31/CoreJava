
class Animal{
	
	protected String behaviour;
	int x;
	double y;
	float z;
	public Animal(String behaviour){
		this.behaviour = behaviour;
	}
	
	public Animal(){
		
	}
	public void eat(){
		System.out.println("eating");
	}
	
	public String getBehaviour(){
		return behaviour;
	}
}


class Dog extends Animal{
	
	public Dog(String behaviour){
		super(behaviour);
		
	}
	
	public void eat(){
		System.out.println("Dog is eating"+behaviour);
		
	}
}


public class Testing {
	public static void main(String args[]){
		
	/*Dog d = new Dog("BHOW BHOW");
	System.out.println(d.getBehaviour());
	d.eat();
	
	
	Animal a = new Dog("Dog");
	System.out.println(a.getBehaviour());
	a.eat();
		
	Animal a1 = new Animal("Hello");
	a1.eat();
	System.out.println(a1.getBehaviour());*/
		
		
	Animal a =new Dog("Bhow Bhow");
	System.out.println(a.behaviour);
	System.out.println(a.x);
	System.out.println(a.y);
	System.out.println(a.z);
	
	
	double x=10;

	switch (String.valueOf(x)) {
	case "Hello":
		System.out.println("Hello");
		break;
	default:
		System.out.println("default");
		break;
	}
	
	
	}
}
