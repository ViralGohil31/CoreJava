package OOP;

import java.io.IOException;

public class OverridingWithDifferentTypeArg {
	public static void main(String[] args) throws Exception {
		Y y = new Z();
		y.print();
		System.out.println(y.i);
		
		Z z = new Z();
		z.print('c');
	}
}


class Y{
	int i=5;
	
	public void print()throws Exception{
		System.out.println("Y");
	}
}


class Z extends Y{
	int i=8;
	
	public void print()throws IOException{
		System.out.println("Z");
	}
	public void print(short a){
		System.out.println("short");
	}
	
	public void print(int a){
		System.out.println("int");
	}
	
	public void print(char a){
		System.out.println("char");
	}
	
	public void print(long a){
		System.out.println("long");
	}
}
