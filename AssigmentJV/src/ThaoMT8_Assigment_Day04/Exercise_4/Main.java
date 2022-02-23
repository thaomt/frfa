package ThaoMT8_Assigment_Day04.Exercise_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input name:");
		String name=scanner.nextLine();
		System.out.println("Input email: ");
		String email=scanner.nextLine();
		System.out.println("Input gender ( only choose m or f ): ");
		char gender=scanner.next().charAt(0);
		Author author=new Author(name, email, gender);
		System.out.println("Information: ");
		System.out.println(author.toString());

	}

}
