package ThaoMT8_Assigment_Day02;
import java.util.Scanner;
/**
 Write a Java program that reads a floating-point number and prints "zero" if the number is zero. Otherwise,
 print "positive" or "negative". Add "small" if the absolute value of the number is less than 1, or "large" if it
 exceeds 1,000,000.
 Test Data
 Input a number: 25
 Expected Output :
 Input value: 25
 Positive number 
 */
public class Exercise_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float number;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input value:");
		number=scanner.nextFloat();
		if(number>0) {
			if(number<1) {
				System.out.println("Positive small");
			}else if(number>1000000) {
				System.out.println("Positive large number");
			}else {
				System.out.println("Positive number number");
			}
			
			
		}else if(number<0) {
			float numberCheck=-number;
			if(numberCheck<1) {
				System.out.println("Negative small number");
			}else if(numberCheck>1000000) {
				System.out.println("Negative large number");
			}else {
				System.out.println("Negative number");
			}
			
		}else {
			System.out.println(0);
		}


	}

}
