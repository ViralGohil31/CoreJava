package MorganStanely;

import java.util.*;
public class WildCardExample {
	public static void main(String[] args) {
		ArrayList<Foo> foos = new ArrayList<>();
		ArrayList<FooChild> foosChild = new ArrayList<>();
		ArrayList<Object> foosObj = new ArrayList<>();
		foos.add(new Foo());
		
		addUpperBound(foos);
		addUpperBound(foosChild);
		//addUpperBound(foosObj);
		
		addLowerBound(foos);
		addLowerBound(foosObj);
		//addLowerBound(foosChild); //Not allowed
	}
	
	public static void addUpperBound(List<? extends Foo> a) {
		
	}
	
	public static void addLowerBound(List<? super Foo> b) {
		
	}
}


class Foo{
	
}

class FooChild extends Foo{
	
}