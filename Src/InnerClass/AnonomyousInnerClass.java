package InnerClass;

public class AnonomyousInnerClass {
	public static void main(String[] args) {
		Inner i= new Inner() {
			@Override
			public void run() {
				System.out.println("Inner Class Example run Override");
			}

			@Override
			public void running() {
				System.out.println("Inner Class Example ruuuning Override");
			}
		};
		i.run();
		i.running();
	}
}


abstract class Inner implements InnerInterface{
	public  abstract void running();
}


interface InnerInterface{
	public void run();
}