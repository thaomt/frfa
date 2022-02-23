package ThaoMT8_Assigment_Day02;

import java.util.Scanner;

/**
 Write a program in Java to display the cube of the number upto given an integer.
Test Data
Input number of terms : 4
Expected Output :
Number is : 1 and cube of 1 is : 1
Number is : 2 and cube of 2 is : 8
Number is : 3 and cube of 3 is : 27
Number is : 4 and cube of 4 is : 64
 */
public class Exercise_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		Scanner scanner=new Scanner(System.in);
		number=scanner.nextInt();
		for(int i=1;i<=number;i++) {
			System.out.println("Number is : "+ i + " and cube of " + i + " is : " + (int)Math.pow(i,3));
		}
		

	}

}
