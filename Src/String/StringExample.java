package String;

public class StringExample {
	public static void main(String[] args) {
		String s = "ABC"; // it will first look into String pool whether the same String are already exist or not.if exist than return the reference of that String from String pool
		String s1 = new String("ABC"); //  this will create Object of String class in Heap Memory.it will not look into String pool memory
		String s3 = "ABC";// it will first look into String pool whether the same String are already exist or not.if exist than return the reference of that String from String pool
		if(s==s1){
			System.out.println("s and s1 are both are of same references or both have same memory references");
		}
		
		
		if(s==s3){
			System.out.println("s and s3 both are having same memory references");
		}
		
		if(s1==s3){
			System.out.println("s1 and s3 both are having same memory references");
		}
		
		
		s = s+"Not valid";
		if(s==s3){
			System.out.println(" After change value of s : s == s3");
		}
		s3 = s3+"Not valid";
		if(s==s3){
			System.out.println(" After change value of s3 : s == s3");
		}
		
		
	}
}
