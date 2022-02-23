package ThaoMT8_Assigment_Day05.exercise1;

/**
 Create a class with a main() that throws an object of class Exception inside a try block. Give the constructor
 for Exception a String argument. Catch the exception inside a catch clause and print the String argument. 
 Add finally clause and print a message to prove you were there. 
 */

public class Exercise_1 {
	public static void main(String[] args) throws Exception {
		
		try {
			String msg="Try catch exp";
			throw new Exception(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally block is always executed");
        }	
	}
	
}
