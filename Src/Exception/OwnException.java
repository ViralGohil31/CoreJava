package Exception;

public class OwnException {
	public static void main(String[] args) throws MyException {
		try{
			throw new MyException("Exception in main");
		}catch(MyException e){
			System.out.println(e.getMessage());
		}
	}
}




class MyException extends Throwable{

	public MyException(String msg){
		super(msg);
	}
}
