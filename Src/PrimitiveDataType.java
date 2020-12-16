/**
 * 
 * byte  : 1 byte means 8 bit signed: able to store 2^7 = -128 to 127
 * short : 2 byte 16 bit signed     : able to store 2^15 = -32,768 to 32767
 * int   : 4 byte 32 bit signed     : able to store -2^31 to 2^31-1 =  
 * long  : 8 byte 64 bit signed		: 
 * double: 
 * char  : 16 bit  
 */
public class PrimitiveDataType {
	public static void main(String[] args) {
		byte a = 127;
		byte b= -127;
		 System.out.println(a+b);
		 
		 short c = 32767;
		 short d = 32767;
		 int e=  c+d;
	}
}
