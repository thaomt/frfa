package ThaoMT8_Assigment_Day01;
import java.util.Scanner;

public class Exercise_1 {
	/*
	 Write a Java program to print the sum of two numbers.
	 Test Data:
	 74 + 36
	 Expected Output :
	 110
	 */
	
	public static void main(String [] args) {
		int number1;
		int number2;
	    Scanner scanner = new Scanner(System.in);
		number1 =scanner.nextInt();
		number2 =scanner.nextInt();
		System.out.print(number1+number2);
		
	}

}
