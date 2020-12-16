package LogicalProgrammingQuestions;

public class ArrayBasedQn {
	public static void main(String[] args) {
		int a[][]= {{123},{4,5,6}};
		int [][]copy = a.clone();
		
		copy[0][0]=100;
		
		System.out.println(a[0][0]);
		System.out.println(copy[0][0]);
		
		copy[1] = new int[] {300,400,500};
		
		System.out.println(a[1][1]);
		System.out.println(copy[1][1]);
		
	}
}
