package Java8Features;

public class LambdaExpressionDefaultInterface {
	public static void main(String[] args) {
		Default d = (a,b)->System.out.println("Mahesh");
		
		Default g = new Default() {
			
			@Override
			public void print(int a, int b) {
				System.out.println("Mahesh");
			}
		};
		
		
		g.print(20, 30);
		d.display();
		d.print(10,20);
		d.printAB(10, 20);
	}

}

interface Default{
	default void display(){
		System.out.println("Hello");
	}
	
	void print(int a,int b);
	
	default void printAB(int a,int b){
		System.out.println("A="+a+" B="+b);
	}
	
	default void printABC(int a,int b){
		
	}
}