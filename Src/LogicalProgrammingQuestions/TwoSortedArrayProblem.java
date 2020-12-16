package LogicalProgrammingQuestions;


/** Problem :
 *	Two array of size n and n+m.first array is completely filled and sorted,second array is containing m element in sorted order. 
 *  now the question is to sort the second array such that it will contain the element of first aaray with the following.
 *  1. second array should remian sorted always.
 *  2. can't use auxilary array.
 *  3. can't use sorting algorithm.
 *
 *  
 *  Solution :
 *  take last element of both array compare both and store the largest in last location of second array than store the second largest in location-1.
 *  do this steps for all element.  
 *   
 *   
 */

public class TwoSortedArrayProblem {
	public static void main(String[] args) {
		int a[] = {0,2,4,6,8,10};
		int b[]  = new int[a.length*2];
		b[0]=1;
		b[1]=3;
		b[2]=5;
		b[3]=7;
		b[4]=9;
		b[5]=11;
		int j=b.length-1;
		for(int i=b.length-a.length-1;i>=0;i--){
			if(a[i]>b[i]){
				b[j]=a[i];
				b[--j]=b[i];
			}else{
				
				b[j]=b[i];
				b[--j]=a[i];
			}
			j--;
		}
		System.out.println("Sorted Array is:");
		for(int i=0;i<=b.length-1;i++){
			System.out.print(b[i]+"\t");
	}
		
}
	
}