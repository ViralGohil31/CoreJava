package LogicalProgrammingQuestions;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringRepeatedCharacter {
	public static void  main(String[] args) {
		String a = "AAABBBCCCDERTRRRPQ";
		System.out.println(removeDuplicate(a));
		
		//OR
		
		Set<Character> s = new LinkedHashSet<Character>();
		for(char c:a.toCharArray()){
			s.add(c);
		}
		
		Iterator<Character> set = s.iterator();
		while(set.hasNext()){
			System.out.print(set.next());
		}
	}
	
	public static String removeDuplicate(String a){
		int index=0;
		char[] b =new char[a.length()];
		char[] c = a.toCharArray();
		for(int i=0;i<c.length;i++){
			if(isAvailable(b,c[i])){
				continue;
			}else{
				b[index++] = c[i];
			}
		}
		return new String(b);
	}
	
	public static boolean isAvailable(char[] b,char c){
		for(int i=0;i<b.length;i++){
			if(c==b[i]){
				return true;
			}
		}
		return false;
	}
}
