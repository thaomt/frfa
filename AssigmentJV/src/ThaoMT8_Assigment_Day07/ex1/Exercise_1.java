package ThaoMT8_Assigment_Day07.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Exercise_1 {

	public static void main(String[] args) {
		String data="Do exercise 1";
		try {
	         OutputStream os = new FileOutputStream("text.txt");
	         byte[] dataBytes=data.getBytes();
	         os.write(dataBytes);   
	         
	         os.close();
	     
	         InputStream is = new FileInputStream("text.txt");
	         int size = is.available();

	         for(int i = 0; i < size; i++) {
	            System.out.print((char)is.read() );
	         }
	         is.close();
	      } catch (IOException e) {
	         System.out.print("Exception");
	      }	
	   }

	

}
