package Java8Features;
/**
 * 
 * If two interface having same method name than class which implments this two interface has to override 
 * these methods.
 *
 */


interface abc{
	default void print(){
		System.out.println("abc");
	}
}

interface bcd{
	default void print(){
		System.out.println("bcd");
	}
}

public class DefaultMethod implements abc,bcd{
	public void print(){
		System.out.println("DefauldMethod");
	}
}
