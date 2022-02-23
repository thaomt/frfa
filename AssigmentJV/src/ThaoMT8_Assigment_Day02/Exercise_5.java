package ThaoMT8_Assigment_Day02;

import java.util.Scanner;

/**
 Compute the natural logarithm of 2, by adding up to n terms in the series
1 - 1/2 + 1/3 - 1/4 + 1/5 -... 1/n
where n is a positive integer and input by user.
 */
public class Exercise_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		Scanner scanner=new Scanner(System.in);
		number=scanner.nextInt();
		double sum=0.0;
		double pos;
		for(int i=1;i<=number;i++) {
			if(i%2==0) {
				 pos=-1.0/i;
				 sum+=pos;
			}else {
				pos=1.0/i;
				sum+=pos;
			}
		}
		System.out.printf("%5f",sum);
	}

}
