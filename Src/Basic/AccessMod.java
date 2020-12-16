package Basic;

public class AccessMod {
	
	public static void main(String[] args) {
		
	}
	
	public void print(){
		AccessmodifierExample acess = new AccessmodifierExample();
		System.out.println(acess.b); //only public access can be allow.
		//System.out.println(a.a); // protected as well not allow it by object creation.it can opnly allow it by inheritence  by this.b
	}
}
