package LogicalProgrammingQuestions;

public class PacalTriangle {
	public static void main(String[] args) {
		new PacalTriangle().pascalTr(4);
		
	}
	
	
	public void pascalTr(int n){
		int[] y= new int[n];
		int a=0;
		for(int u=n;u>=1;u--) {
			if(u%2==1) {
				y[a]=u;
				a++;
			}
		}
		for(int z=0;z<y.length;z++) {
			System.out.println(y[z]);
		}
		
				
		for(int i=0;i<y.length;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			
			for(int k=0;k<y[i];k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
}
