package OOP;

public class TypeCating {
	public static void main(String[] args) {
		Object o = new Horse();
		Horse a  = (Horse)o;//Down casting
		
		Animal1 a1 = new Horse();
		Horse a2 = (Horse)a1; // Down  casting
		
		Horse h1 = new Horse();
		Animal1 a3 = (Animal1)h1; // Up casting
		
		if(a3 instanceof Animal1){
			System.out.println("a3 instanceof Animal1");
		}
		
		if(a3 instanceof Horse){
			System.out.println("a3 instanceof Horse");
		}
		
		
		if(h1 instanceof Animal1){
			System.out.println("h1 instanceof Animal1");
		}
		
		if(h1 instanceof Horse){
			System.out.println("h1 instanceof Horse");
		}
		if(h1 instanceof Object){
			System.out.println("a3 instanceof Object");
		}
		
		
	}
}
