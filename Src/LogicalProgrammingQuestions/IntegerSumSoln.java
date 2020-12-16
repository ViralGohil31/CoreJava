package LogicalProgrammingQuestions;

import java.util.HashSet;
import java.util.Set;

public class IntegerSumSoln {
	public static void main(String[] args) {
		int[] a= {10,5,-1,-2,3,6,2};
		int k=8;
		Set<Integer> s = new HashSet<Integer>();
		
		for(int i=0;i<a.length;i++) {
			if(k>a[i]) {
				int find = k - a[i];
				if(s.contains(find)) {
					System.out.println(a[i]+","+find);
				}
			}else {
				int find =  a[i]-k;
				if(s.contains(find)) {
					System.out.println(a[i]+","+find);
				}
			}
			s.add(a[i]);
		}
	}
}
