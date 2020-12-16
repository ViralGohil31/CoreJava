package Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapReduceOperation {
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(10,20,30,40,50);
		Stream s1 = a.stream().map(i->i*2);
		s1.forEach(value->System.out.println(value));
		System.out.println("Reduce Function : Addition" + a.stream().map(i->i*2).reduce(0,(c,i)->c+i));
		
		
		//OR
		System.out.println("Implementation using anonymous class");
		Function<Integer,Integer> f = new Function<Integer,Integer>(){
			@Override
			public Integer apply(Integer t) {
				return t*2;
			}
		};
		
		Stream s3 = a.stream();
		Stream s4 = s3.map(f);
		s4.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		});
		
		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
					return t+u;
			}
			
		};
		
		System.out.println("Reduce Function : Addition "+a.stream().map(i->i*2).reduce(0,b));
	}
}
