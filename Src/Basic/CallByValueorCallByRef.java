package Basic;
/**
 * Java call the method by primitive type by variable by value not by reference.
 * 
 *
 */


public class CallByValueorCallByRef {
	static int a=101;
	static String s1 = "abc";
	static String s2 = new String("XYZ");
	public static void main(String[] args) {
		
		
		Example e = new Example();
		e.setA(10);
		new CallByValueorCallByRef().CallByValue(a, e,s1,s2);
		System.out.println("Primitive type value "+a+ 
				"Object value after A: "+e.getA()+" B: "+e.getB()+" value of s1 "+s1+"Value of String s2 "+s2);
		
		// Value of String s1 and s2 will get change because String is Immutable object once the object property change it will create 
		//new instance of String.
	}
	
	public  void CallByValue(int a,Example e,String s,String s2){
		e.setB(20); // e.b=20
		e.setA(88); //e.a = 88
		a = 12;
		s="bcd";
		s2 = "CHANGE";
	}
}


class Example{
	int a;
	int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
}
