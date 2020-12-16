package MorganStanely;

public class TryCatchExample {
	public static void main(String[] args) {
		TryCatchExample t = new TryCatchExample();
		System.out.println(t.tryCatch());;
		
	}
	public int tryCatch() {
		try {
			throw new RuntimeException();
		}catch(Exception e) {
			System.out.println("Catch Block");
			return 0;
		}finally {
			System.out.println("finally Block");
			return 1;
		}
	}
	
}
