package MorganStanely;

public class MethodCallExample {
	public static void main(String[] args) {
		MethodCallExample m = new MethodCallExample();
		m.getData(null);
		m.getData(new String("a"));
		m.getData(new Object());
		
	}
	
	/*public void getData(String a) {
		System.out.println("String version getData Called");
	}*/
	
	public void getData(Object a) {
		System.out.println("Object Version getData Called");
	}
	
}
