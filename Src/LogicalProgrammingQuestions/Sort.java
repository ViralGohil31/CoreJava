package LogicalProgrammingQuestions;

public class Sort {
	public static void main(String[] args) {
		int []a={9,8,7,6,5,4};
		int temp;
		System.out.println(a);
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				if(a[i]>a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.println(a);
	}
}
