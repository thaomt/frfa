package ThaoMT8_Assigment_Day02;

import java.util.Scanner;

/**
 Write a program in Java to make such a pattern like right angle triangle with a number which will repeat a
number in a row.The pattern is as follows :
1
22
333
4444
 */
public class Exercise_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		Scanner scanner=new Scanner(System.in);
		number=scanner.nextInt();
		for(int i=1;i<=number;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i);
			}
			System.out.println();
		}

	}

}
