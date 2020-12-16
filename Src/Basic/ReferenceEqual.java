package Basic;

public class ReferenceEqual {
	public static void main(String[] args) {
		P1 a= new P1();
		P1 b = new P1();
		if(a==b) {
			System.out.println("a==b");
		}
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}
}




class P1{
	@Override
	public int hashCode() {
		return 0;
	}
}