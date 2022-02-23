package ThaoMT8_Assigment_Day01;
import java.util.Scanner;

/*
  Write a Java program that accepts two integer values from the user and return the larger values. However if 
  the two values are the same, return 0 and return the smaller value if the two values have the same remainder 
  when divided by 6.
  Sample Output:
  Input the first number : 12 
  Input the second number: 13 
  Result: 13

 */

public class Exercise_4 {
	int number1;
	int number2;
	public void checkNumber() {
		int res=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input the first number:");
		number1=scanner.nextInt();
		System.out.println("Input the second number:");
		number2=scanner.nextInt();
		if(number1==number2) {
			System.out.println(res);
		}else {
			if(number1%6==number2%6) {
			   System.out.println(res=number1<number2?number1:number2);
			}else {
			   System.out.println(res=number1>number2?number1:number2);
			}
		}
	}
	public static void main(String [] args) {
		Exercise_4 exercise_4=new Exercise_4();
		exercise_4.checkNumber();
	}
}
