package MorganStanely;

public class InstanceBlockStaticBlock {


	public static void main(String[] args) {
		Sample t = new Sample();
		
	}
}

class SampleParent{
	public SampleParent() {
		System.out.println("Parent");
	}
}
class Sample extends SampleParent{
	
	Sample(){
		System.out.println("Sample");
	}
	{
		System.out.println("instance block1");
	}
	
	
	static {
		System.out.println("Static 1");
	}
	{
		System.out.println("instance Block2");
	}
	static{
		System.out.println("static 2");
	}
}

