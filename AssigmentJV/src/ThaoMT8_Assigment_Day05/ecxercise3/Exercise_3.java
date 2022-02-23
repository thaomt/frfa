package ThaoMT8_Assigment_Day05.ecxercise3;

/**
 Create a three-level hierarchy of exceptions. 
 Now create a base-class A with a method that throws an exception at the base of your hierarchy. 
 Inherit B from A and override the method so it throws an exception at level two of your hierarchy. 
 Repeat by inheriting class C from B. In main( ), create a C and up cast it to A, then call the method. 
 */

class LevelOneException extends Exception {}

class LevelTwoException extends LevelOneException {}

class LevelThreeException extends LevelTwoException {} 

class A {
	void method() throws LevelOneException {
		throw new LevelOneException();
	}
}

class B extends A {
	@Override
	void method() throws LevelTwoException {
		throw new LevelTwoException();
	}
}

class C extends B {
	@Override
	void method() throws LevelThreeException {
		throw new LevelThreeException();
	}
}

public class Exercise_3 {
	public static void main(String[] args) {
		A a = new C();
		try {
			a.method();
		}	catch(LevelThreeException e3) {
			System.out.println("Caught exception3");			
		}	catch(LevelTwoException e2) {
			System.out.println("Caught exception2");
		}	catch(LevelOneException e1) {
			System.out.println("Caught exception1");
		}		
	}
}