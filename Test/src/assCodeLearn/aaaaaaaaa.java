package assCodeLearn;

class Myexception extends Exception {
	int detail;

	Myexception(int a) {
		detail = a;
	}

	public String toString() {
		return "detail";
	}
}

public class aaaaaaaaa {
	static void compute(int a) throws Myexception {
		throw new Myexception(a);
	}

	public static void main(String args[]) {
		try {
			compute(3);
		} catch (Exception e) {
			System.out.print("Exception");
		}
	}

}
