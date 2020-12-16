package Basic;

public class FinalFinallyFinalizeExample {
	
	public final void print(){
		System.out.println("print");
	}
	public void print(String c){
		System.out.println("print");
	}
	public static void main(String[] args) throws Exception {
		try{
			final int a;
			a=10;
			//you cannot reinitilize variable which marked final//a=20;
			
			throw new Exception("Error");
		}finally{
			System.out.println("finally");
		}
	}
}



final class abc extends FinalFinallyFinalizeExample{
	//You cannot able override final method
	/*public  void print(){
		
	}*/
	
	public void print(String c){
		System.out.println("print"+c);
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}



//You cannot extend class which marked final
/*class bcd extends abc{
	
}*/