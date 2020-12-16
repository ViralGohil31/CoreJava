package OOP;

public class Overriding {
	public static void main(String[] args) {
		abc a = new bcd("Message");
		a.Println("abc");
		a.sayHello();
		bcd b = new bcd("MEESAGE");
		b.getMessage();
		
		Animal[] animal = {new Dog(),new Cat(),new Dog(),new Cat()};
		AnimalDoctor doc = new AnimalDoctor();
		doc.AnimalCheckUp(animal);
	}
	
}




class abc{
	String msg;
	public abc(String msg){
		this.msg = msg;
	}
	public void Println(String a){
		System.out.println("abc");
	}
	public void getMessage(){
		System.out.print(msg);
	}
	
	public void sayHello(){
		System.out.println("Hello");
	}
	
	
}


class bcd extends abc{
	public bcd(String msg){
		super(msg);
	}
	public void Println(Object o){
		System.out.println("bcd");
	}
	
	public void sayHi(){
		System.out.println("HI");
	}
}

/********************Example2 for Overriding*****************************/

class Animal{
	String animalType;
	public Animal(String arg){
		this.animalType = arg;
	}
	
	public void CheckUp(){
		System.out.print("Animal");
	}
}

class Dog extends Animal{
	public Dog(){
		super("Dog");
	}
	
	public void CheckUp(){
		System.out.println("DOG Checkup");
	}
}

class Cat extends Animal{
	public Cat(){
		super("CAT");
	}
	
	public void CheckUp(){
		System.out.println("Cat Checkup");
	}
}

class AnimalDoctor{
	public void AnimalCheckUp(Animal[] animal){
			for(Animal a:animal){
				a.CheckUp();
			}
	}
}