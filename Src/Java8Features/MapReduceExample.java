package Java8Features;

import java.util.Arrays;
import java.util.List;

public class MapReduceExample {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println("Old way to double and total values");
		int total=0;
		for(int e:values){
			total +=e*2;
		}
		System.out.println("TOTAL "+total);
		
		System.out.println("New Way to Double and total values");
		System.out.print(values.stream().map(e->e*2).reduce(0,(c,e)->c+e));
		
	}
}
