package LogicalProgrammingQuestions;

import java.util.Scanner;

public class StaticB {
	static int B,H;
	static int area;
	static boolean flag=false;
	static{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Breadth");
	    B = sc.nextInt();
	    System.out.println("Enter the Height");
	    H = sc.nextInt();
	    
	    if(B>0 && H>0){
	      flag = true;
	    }else{
	        System.out.println("java.lang.Exception: Breadth and height must be positive");
	    }
	    String.val
	}
	
	public static void main(String[] args) {
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
	}
}




//-100 && 100



