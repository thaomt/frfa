package ThaoMT8_Assigment_Day05.exercise2;

import java.util.Scanner;

public class ExceptionTest {
	public void method() throws OwnException{
	    try {
	    	int data = 25 / 0;
            System.out.println(data);
	    } catch (ArithmeticException  e) {
	        throw new OwnException("Can't div 0");
	    }
	}
	
	public static void main(String args[]){
		ExceptionTest obj=new ExceptionTest();
		try {
			obj.method();
		} catch (OwnException e) {
			System.out.println("Error found: "+e.getMessage());	
			e.printStackTrace();
		}
	}

}
