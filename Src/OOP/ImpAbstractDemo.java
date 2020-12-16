package OOP;

public class ImpAbstractDemo {
	public static void main(String[] args) {
		Abcde a = new Abcdefg();
		a.run();
	}
}


interface Ab{
	public void run();
}

abstract class Abcde implements Ab{
	
}



class Abcdefg extends Abcde{
	public void run(){
		
	}
}
