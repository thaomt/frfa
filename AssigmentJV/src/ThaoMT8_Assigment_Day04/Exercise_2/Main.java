package ThaoMT8_Assigment_Day04.Exercise_2;
/**
 Create an abstract class 'Parent' with a method 'message'. 
 It has two subclasses each having a method with the same name 'message' 
 that prints "This is first subclass" and "This is second subclass" respectively. 
 Call the methods 'message' by creating an object for each subclass.
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent subclass1= new SubClass1();
		Parent subclass2=new SubClass2();
		subclass1.message();
		subclass2.message();

	}

}
