package MorganStanely;

public class ConstructorExample {

}



class Base{
	/*public Base(String info) {
		System.out.println("Base "+info);
	}*/
	
	public Base() {
		System.out.println("Base");
	}
}


class Child extends Base{

	/*public Child(String info) {
		super(info);
		// TODO Auto-generated constructor stub
	}*/
	
	public Child() {
		System.out.println("Child");
	}
	
	/*public Child() {
		//super("");
		this("A");
		System.out.println("Child");
	}
	
	public Child(String info) {
		super(info);
		System.out.println(info);
	}*/
}