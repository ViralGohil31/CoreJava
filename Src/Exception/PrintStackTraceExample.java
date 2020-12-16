package Exception;

public class PrintStackTraceExample {
	public static void main(String[] args) {
		try{
			System.out.println("main method");
			callMethod1();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void callMethod1()throws Exception{
		System.out.println("callMethod1 method");
		callMethod2();
	}
	
	public static void callMethod2()throws Exception{
		System.out.println("callMethod2 method");
		callMethod3();
	}
	
	public static void callMethod3()throws Exception{
		try{
			System.out.println("callMethod3 method");
			throw new  Exception("Exception inside CallMethod3");
		}catch(Exception e){
			e.printStackTrace();
			throw e;

		}
	}
}
