package Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsExample {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<100;i++){
			list.add(i);
		}
		
		
		List<String> stringlist = new ArrayList<String>();
		for(int i=0;i<100;i++){
			stringlist.add("abc");
		}
		
		//Sequential Stream
		Stream<Integer> s = list.stream();
		//Parallel Stream
		Stream<Integer> p = list.parallelStream();
		
		Stream<Integer> highestNo = p.filter(p1->p1>90);
		highestNo.forEach(p1->System.out.println(p1));
		
		/*Stream<Integer> integer = p.map(r->r.)*/
		Stream<String> t = stringlist.parallelStream();
		Stream<String> map = t.map(q->q.toUpperCase());
		
		/*Stream<String> red = t.reduce("", (a,b)->a+b);*/
		map.forEach(p1->System.out.println(p1));
		
		
		
	}
}
