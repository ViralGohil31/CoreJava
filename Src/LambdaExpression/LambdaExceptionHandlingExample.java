package LambdaExpression;

import java.util.function.BiConsumer;

public class LambdaExceptionHandlingExample {
	public static void main(String[] args) {
		int[] someNumbers = {1,2,3,4,5,6};
		int key=0;
		process(someNumbers, key, wrapperConsumer((v,k)->System.out.println(v/k)));
	}
	
	
	private static void process(int[] someNos,int key,BiConsumer<Integer, Integer> consumer) {
		for(int i:someNos) {
			consumer.accept(i, key);
		}
	}
	
	
	private static BiConsumer<Integer,Integer> wrapperConsumer(BiConsumer<Integer, Integer> consumer){
		return (v,k)-> {
			try {
			consumer.accept(v, k);
		}catch (Exception e) {
			System.out.println(e.getMessage()+ "Exception");
		}
		};
	}
}
