package ThaoMT8_Assigment_Day02;

import java.util.Scanner;

/**
 Write a program to print out all Armstrong numbers between 1 and 500. If sum of cubes of each digit of the
number is equal to the number itself, then the number is called an Armstrong number.
For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ) 
 */
public class Exercise_4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		for(int i=1;i<=500;i++) {
			int sumCheck=0;
			int numberCheck=i;
			for(int j=1;j<=i;j++) {
				int divNum=numberCheck%10;
				numberCheck=numberCheck/10;
				sumCheck+=Math.pow(divNum, 3);
			}
			if(i==sumCheck) {
				System.out.println(i);
			}
		}

	}

}
