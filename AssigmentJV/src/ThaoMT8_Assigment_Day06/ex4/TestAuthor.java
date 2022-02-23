package ThaoMT8_Assigment_Day06.ex4;

import java.util.Scanner;

public class TestAuthor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input name:");
		String name=scanner.nextLine();
		System.out.println("Input email: ");
		String email=scanner.nextLine();
		System.out.println("Input gender ( only choose m or f ): ");
		char gender=scanner.next().charAt(0);
		Author author = new Author(name, email, gender); // Test the constructor
		System.out.println(author.toString());  // Test toString()
		author.setEmail("thao@fpt.com");  // Test setter
		System.out.println("name is: " + author.getName());     // Test getter name
		System.out.println("eamail is: " + author.getEmail());   // Test getter email
		System.out.println("gender is: " + author.getGender()); // Test getter gender

	}

}
