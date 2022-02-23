package ThaoMT8_Assigment_Day03.Exercise_1;
/**
 Create a class named 'Student' with String variable 'name' and integer variable 'roll_no'. Assign the value of
roll_no as '2' and that of name as "John" by creating an object of the class Student. 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setName("John");
		student.setRoll_no(2);
		System.out.println("Student has name: "+ student.getName()+"\n"+ "Roll_no: "+student.getRoll_no());

	}

}
