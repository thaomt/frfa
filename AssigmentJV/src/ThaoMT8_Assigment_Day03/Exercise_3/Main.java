package ThaoMT8_Assigment_Day03.Exercise_3;
/**
 Write a program that would print the information (name, year of joining, salary, address) of three employees
by creating a class named 'Employee'. The output should be as follows:
Name Year of joining Address
Robert 1994 64C- WallsStreat
Sam 2000 68D- WallsStreat
John 1999 26B- WallsStreat 
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Name"+"   "+" Year of joining"+"   "+" Address");
		Employee employee1=new Employee("Robert",1994,"64C- WallsStreat");
		employee1.printInfo();
		Employee employee2=new Employee("Sam",2000,"68D- WallsStreat");
		employee2.printInfo();
		Employee employee3=new Employee("John",1999,"26B- WallsStreat");
		employee3.printInfo();

	}

}
