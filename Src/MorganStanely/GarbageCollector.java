package MorganStanely;

public class GarbageCollector {
	public static void main(String[] args) {
		
	}
}


class BaseClass{
	
}

class MyClass extends BaseClass{
	 { 
	        // How many objects are eligible for  
	        // garbage collection after this line? 
	        m1();  // Line 5 
	    } 
	  
	    static void m1()  
	    { 
	        BaseClass t1 = new BaseClass(); 
	        BaseClass t2 = new BaseClass(); 
	    }  
}

//Answer =2 // Both the object are eligible for Garbage Collector becuase once the method completed all the object are become unused.