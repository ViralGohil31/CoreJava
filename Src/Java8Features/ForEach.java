package Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEach {
	public static void main(String[] args) {
		List<Integer> a =  Arrays.asList(1,2,3,4,5,6,7,8,9);
		for(int i=0;i<a.size();i++){
			System.out.print(" "+a.get(i));
		}
		System.out.println("\nExternal Iterator");
		for(int val:a){
			System.out.print(" "+val);
		}
		
		System.out.println("\nFor Each using Internal Iterator");
		a.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.print(" "+t);
				
			}
			
		});
		
		System.out.println("\nFor Each Using Lambda expresion");
		a.forEach((Integer e)->System.out.print(" "+e));
		//or 
		System.out.println("\nFor Each Using Lambda expresion");
		a.forEach((e)->System.out.print(" "+e));
		
		System.out.println("\nFor Each Method references");
		a.forEach(System.out::println);
	}
}
