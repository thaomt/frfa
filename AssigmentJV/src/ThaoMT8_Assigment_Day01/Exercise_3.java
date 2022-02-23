package ThaoMT8_Assigment_Day01;
import java.util.Scanner;

/*
  Write a Java program to multiply two binary numbers.
  Input Data:
  Input the first binary number: 10
  Input the second binary number: 11
  Expected Output
  Product of two binary numbers: 110
 */
public class Exercise_3 {
	public static void main(String[] args){
	  String binary1;
	  String binary2;
	  Scanner scanner=new Scanner(System.in);
	  System.out.println("Input the first binary number:");
	  binary1=scanner.nextLine();
	  int dis1=Integer.parseInt(binary1,2);
	  System.out.println("Input the second binary number:");
	  binary2=scanner.nextLine();
	  int dis2=Integer.parseInt(binary2,2);
	  System.out.println("Product of two binary numbers:" + Integer.toBinaryString(dis1*dis2));
	  
	}
}
