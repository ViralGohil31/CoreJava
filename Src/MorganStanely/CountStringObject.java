package MorganStanely;

public class CountStringObject {
	public static void main(String[] args) {
		String a = "A"; //new Obj Created 1
		String b = "B"; //new Obj Created 2
		String f = "AB"; //Will create new obj3
		String c = "A"+"B"; //will not create
		String d = a+"B"; //Will create new object
		String e = "A"+b; //will create new object
		 
		String g = new String("A"); //will  Create new obj 
		String h = new String("AB"); //will create new obj
		String i = a; //will not create
		
		//System.out.println("c "+c.hashCode()+" d "+f.hashCode());
		
		Object objc = (Object)c;
		Object objd = (Object)d;
		
		
		if(d==f) {
			System.out.println("equal");
		}
	}
}
