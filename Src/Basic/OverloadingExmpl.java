package Basic;


/*short 2 bytes
int 4 bytes
long 8 bytes
*/
public class OverloadingExmpl {
	public static void main(String[] args) {
		OverloadingExmpl o = new OverloadingExmpl();
		o.getNumber(new Integer(10));
		o.getNumber(10);
		o.getNumber(5.5);
	}
	
/*	public void getNumber(int a) {
		System.out.println("int");
	}
	*/
	/*public void getNumber(Number a) {
		System.out.println("Number");
	}
*/
	

	public void getNumber(long a) {
		System.out.println("long"); //8 bytes
	}
	
/*	public void getNumber(float a) {
		System.out.println("float "+a);
	}
	
	public void getNumber(double a) {
		System.out.println("double");  //8 bytes
	}
	*/
	public void getNumber(Object a) {
		System.out.println("Object"); 
	}
	
	public void getNumber(Float a) {
		System.out.println("Float");
	}
	
	
	public void getNumber(double a) {
		System.out.println("double");
	}
	
	public void getNumber(float a) {
		System.out.println("float");
	}
}
