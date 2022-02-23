package ThaoMT8_Assigment_Day03.Exercise_4;

import java.util.Scanner;

/**
 Write a program by creating an 'Employee' class having the following methods and print the final salary.
1 - 'getInfo()' which takes the salary, number of hours of work per day of employee as parameter
2 - 'AddSal()' which adds $10 to salary of the employee if it is less than $500.
3 - 'AddWork()' which adds $5 to salary of employee if the number of hours of work per day is more than 6
hours. 
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number of hours");
		double number_of_hours = sc.nextDouble();
		System.out.println("Input salary");
		double salary = sc.nextDouble();
		Employee employee=new Employee(number_of_hours,salary);		
		salary = employee.AddSal();
		salary = employee.AddWork();
		System.out.println("Final salary: " + employee.getInfo(number_of_hours,salary)+ " $");

	}

}
