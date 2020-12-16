package AccessModifier;

import Basic.AccessmodifierExample;

public class AccessModiOfBasic extends  AccessmodifierExample{
	public static void main(String[] args) {
		new AccessModiOfBasic().print();
	}
	
	public String print(){
		AccessmodifierExample acess = new AccessmodifierExample();
		System.out.println(acess.b); //only public access can be allow.
		//System.out.println(a.a); // protected as well not allow it by object creation.it can opnly allow it by inheritence  by this.b
		
		
		System.out.println(this.a); // protected can access by inheritence
		System.out.println(this.b); // public can access
		//System.out.println(this.c); // C cannot access because it is default modifier .so it can access it within package 
		//System.out.println(this.abc);//private modifier cannot access
		return a;
	}
}
