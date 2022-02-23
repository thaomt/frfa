package ThaoMT8_Assigment_Day04.Exercise_1;
/**
 Write a program to print the names of students by creating a Student class. 
 If no name is passed while creating an object of Student class, 
 then the name should be "Unknown", otherwise the name should be equal to the
 String value passed while creating object of Student class.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1=new Student("Thao");
		Student student2=new Student();
		student1.printName();
		student2.printName();
		    
		
	}

}
