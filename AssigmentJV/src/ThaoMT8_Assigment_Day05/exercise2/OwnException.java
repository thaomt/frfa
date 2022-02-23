package ThaoMT8_Assigment_Day05.exercise2;
/**
Create your own exception class using the extends keyword. Write a constructor for this class that takes a
String argument and stores it inside the object with a String reference. 
Write a method that prints out the stored String. 
Create a try-catch clause to exercise your new exception 
*/

public class OwnException extends Exception{
	 public OwnException(String s) {
		super(s);
		System.out.println("OwnException(String s)");
	}
}
