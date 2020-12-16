package SocketPrograming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static Socket socket;
		public static void main(String[] args) {
			try{
			ServerSocket serverSoc= new  ServerSocket(25000);
			System.out.println("Server Started listening to the port");
			while(true){
				socket = serverSoc.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader inReader  = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(inReader);
				String input = br.readLine();
				System.out.println(input);
				
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter ow =  new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(ow);
				bw.write("I m Server");
				bw.flush();
			}
				
			}catch(Exception e){
				System.out.println("error in Server");
			}finally{
				try{
					socket.close();
				}catch(Exception e){
					System.out.println("error while closing Socket");
				}
			}
	}
}
