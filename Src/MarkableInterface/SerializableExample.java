package MarkableInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableExample implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int a;
	int b;
	transient int c;
	public SerializableExample(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public static void main(String[] args) {
		SerializableExample s = new SerializableExample(10, 20,30);
		try{
			//Serializable
			FileOutputStream fout = new FileOutputStream("f.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s);
			out.flush();
			
			//Deserializable
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
			SerializableExample s1 = (SerializableExample)in.readObject();
			System.out.println(" a= "+s1.a+" b= "+s1.b+" c= "+s1.c);
			
		}catch(Exception e){
			System.out.println("File Not Found");
		}
	}
}
