package LogicalProgrammingQuestions;

import java.util.StringTokenizer;

public class Pangram {
	public static void main(String[] args) {
		String str = " ABCD EFGH IJKL MNOPQR STUVW XY";
		
		boolean []mark= new boolean[26];
		int index;
		for(int i=0;i<str.length();i++) {
			if('A'<=str.charAt(i) && str.charAt(i)<='Z' && ' '!=str.charAt(i)) {
				index = str.charAt(i) - 'A';
				mark[index] = true;
			}else if('a'<=str.charAt(i) && str.charAt(i)<='z'  && ' '!=str.charAt(i)) {
				index = str.charAt(i) - 'a';
				mark[index] = true;
			}
			
		}
		
		for(int k=0;k<mark.length;k++) {
			if(mark[k]==false) {
				int val = k+'A';
				char c = (char)val;
				System.out.println(c);
			}
		}
		
		
		System.out.println(str.length());
		System.out.println(str.charAt(0));
	}
}
