package LambdaExpression;

import java.util.*;
import java.util.stream.Stream;
public class Java8StreamExample {
	public static void main(String[] args) {
		//Integer[] a = new Integer[10];
		List<Integer> list= new ArrayList<Integer>();
		list.addAll(Arrays.asList(2,3,4,5,6,7,8,9));
		
		Stream s = list.stream().map(i->i*2);
		System.out.println(list.stream().anyMatch(p->{
			if(p==2) return true;
			return false;
		}));;
		
		
		list.stream().filter(p->p>2).collect();
		
	}
}
