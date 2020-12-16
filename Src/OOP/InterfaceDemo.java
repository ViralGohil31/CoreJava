package OOP;

import java.util.ArrayList;
import java.util.List;

public class InterfaceDemo {
	 static public void main(String args[]){
		 Interface i = new Demo();
		 i.doIt();
		 Interface.print();
		List<String> a = i.sayHello();
		System.out.println(a.get(0));
		System.out.println(Interface.a);
	}
}

class Demo implements Interface{

	public void doIt() {
	
		System.out.println("Helo");
	}
	
	public List<String> sayHello(){
		ArrayList<String> a = new ArrayList<String>();
		a.add("Hello");
		return a;
		
	}
}

abstract interface Interface{
	//protected void doIt(); //protected method are not allowd in interface only public ,abstract,default,static & stristfp
	public void doIt();
	 List sayHello(); // it will converted into public abstract by compiler
	 int a=10; // It will converted into public static final by compiler
	 static void print(){
		 System.out.println("Print");
	 }
}
