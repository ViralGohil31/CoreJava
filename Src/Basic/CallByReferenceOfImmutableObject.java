package Basic;

public class CallByReferenceOfImmutableObject {
	static String p;
	public static void main(String[] args) {
		CallByReferenceOfImmutableObject c = new CallByReferenceOfImmutableObject();
		Person q = new Person(10,5f);
		
		String a="A";
		Integer b=20;
		p="10";
		c.reference(a,p,b,q);
		System.out.println(a);
		System.out.println(p);
		System.out.println(b);
		System.out.println(q.getHeight()); // for Person is not immutable object so if the value get change of the member variable so we can able to access 
	}
	
	public void reference(String a,String p,Integer b,Person q) {
		a = "B";
		this.p="30";
		b= 90;
		q.setHeight(6);
		
	}
	
}



class Person{
	int sal;
	float height;
	
	
	public Person(int sal, float height) {
		super();
		this.sal = sal;
		this.height = height;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
}

