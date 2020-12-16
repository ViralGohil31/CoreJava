package String;

public class StringBuilderExample {
	public static void main(String[] args) {
		
		/***********StringBilder*****************/
		StringBuilder sb = new StringBuilder("Hi");
		StringBuilder sb1 = sb;
		
		sb.append("Hello Hello Heloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		sb.append("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddwewewewewewewewewewewewewewewewewewewe");
		sb.append("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssasasasassasassasasasasasasa");
		sb.append("dfidfodfodsosuoisuroseuroseuoseurtosei'iaoruoituoatpitpowuotuoituoutwouowutotuotuoutowutowutowa'tu'otusjusu09uw9uitpojtsojusopruiweruwursufusuoruoru");
		
		System.out.println("After adding String to StringBuilder");
		if(sb1 == sb){
			System.out.println("sb1== sb");
		}
		
		/************String**************/
		
		String s1 = "Hello";
		String s2 = s1;
		if(s1==s2){
			System.out.println("s1 == s2 ");
		}
		s1= s1+"How r u!";
		System.out.println("After adding value to String s1");
		if(s1==s2){
			System.out.println("s1 == s2 String");
		}
		
		
	}
}
