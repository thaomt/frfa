package ThaoMT8_Assigment_Day04.Exercise_3;

import java.util.Scanner;

/**
 Write a class that implements the CharSequence interface found in the java.lang package. 
 Your implementation should return the string backwards. 
 Select one of the sentences from this book to use as the data. 
 Write a small main method to test your class; make sure to call all four methods
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sequenceChar = new String();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input char sequence: ");
		sequenceChar=scanner.nextLine();
		CharSequenceImplement s =new CharSequenceImplement(sequenceChar);
		System.out.println("The string backwards:");
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
		}
	}

}
