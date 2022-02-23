package ThaoMT8_Assigment_Day06.ex1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 Write a Java program to replace the second element of a ArrayList with the specified element. 
 */
public class Exercise1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println("ArrayList original: "+list);
		System.out.println("Input element to replace the second element:");
		int element=scanner.nextInt();
		list.set(1, element);
		System.out.println("new ArrayList : "+list);

	}

}
