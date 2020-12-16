package LogicalProgrammingQuestions;

public class SwappingTwoNoWithoutUseTempVariable {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.println("Before Swapping a= " + a+" b= "+b);
		SwappingTwoNoWithoutUseTempVariable s = new SwappingTwoNoWithoutUseTempVariable();
		s.Swap(a, b);
	}
	
	public void Swap(int a,int b){
		a = a+b;
		b=a-b;
		a = a-b;
		System.out.println("After Swaping   a= " + a+" b= "+b);
	}
	
}
