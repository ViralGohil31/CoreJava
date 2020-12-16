package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadLargeFile {
	 
	public static void main(String[] args) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		List<String> list = new ArrayList<String>();
		int mb=1024*1024;
		try {
		    inputStream = new FileInputStream("F://MOVIES/shaadi.mein.zaroor.aana.2017.mp4");
		    sc = new Scanner(inputStream, "UTF-8");
		    System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory() / mb);
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        //list.add(line);
		        long usedMemory = Runtime.getRuntime().totalMemory()  - Runtime.getRuntime().freeMemory();
		        System.out.println("Used Memory: "
						+ ( usedMemory/ mb));
		 
				// Maximum available memory
				System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory()  / mb);
		        
		        System.out.println("Reading");
		        // System.out.println(line);
		    }
		    
		    System.out.println("File Reading Done");
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}
}
