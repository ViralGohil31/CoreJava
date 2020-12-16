package MorganStanely;

public class IntegerStringCallByReferenceExample {
	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		swap(a, b);
		System.out.println("a = "+a+" b = "+b);
		
		//String 
		
		String c = "10";
		String d = "20";
		swap(c, d);
		
		System.out.println("c = "+c+" d = "+d);
	}
	
	public static void swap(Integer a,Integer b) {
		Integer temp = new Integer(10);
		//Integer temp;
		temp = a;
		a = b;
		b = temp;
	}
	
	public static void swap(String a,String b) {
		String temp = new String("10");
		
		temp = a;
		a = b;
		b = temp;
	}
}
