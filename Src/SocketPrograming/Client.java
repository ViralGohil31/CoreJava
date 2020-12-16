package SocketPrograming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
		private static Socket socket;
		public static void main(String[] args) {
			String host  = "localhost";
			try{
				InetAddress address = InetAddress.getByName(host);
				System.out.println(address);
				socket = new Socket("localhost",25000);
				System.out.println("Connecting...");
		
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter ow =  new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(ow);
				PrintWriter out = new PrintWriter(bw,true);
				out.write("I m Client");
				System.out.print("Sucessfulyy Sent");
				
				
				InputStream is = socket.getInputStream();
				InputStreamReader inReader  = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(inReader);
				String input = br.readLine();
				System.out.println(input);
				
				
			}catch(Exception e){
				System.out.println("");
			}finally{
				try{
					socket.close();
				}catch(Exception e){
						System.out.println("error while closing Socket"+e);
					}
				
			}
		}
}
