package LogicalProgrammingQuestions;

public class StringWithSpecialCharProblem {
	public static void main(String[] args) {
		String a  = "abc*ghi";
		String b =  "abcdefghi";
		int j=0;
		int p=0;
		for(int i=0;i<a.length();i++){
			//System.out.println(a.charAt(i)+" "+b.charAt(j));
			if(a.charAt(i)!=b.charAt(j) && a.charAt(i)!='*' && a.charAt(i)!='_'){
				System.out.println("Not valid String");
			}
			if(a.charAt(i)=='*'){
				for(p=j;p<b.length()-1;p++){
					//System.out.println("           "+b.charAt(p));
					if(a.charAt(i+1)==b.charAt(p)){
						break;
					}
				}
				j=p-1;
			}
			
			j++;
		}
		
	}
}
