/**
 Write a program to print the area of a rectangle by creating a class named 'Area' taking the values of its length
and breadth as parameters of its constructor and having a method named 'returnArea' which returns the area
of the rectangle. Length and breadth of rectangle are entered through keyboard.
 */
package ThaoMT8_Assigment_Day03.Exercise_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lenght;
		int breadth;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input lenght: ");
		lenght=scanner.nextInt();
		System.out.println("Input breadth: ");
		breadth=scanner.nextInt();
		Area area=new Area(lenght,breadth);
		area.returnArea();
	}

}
