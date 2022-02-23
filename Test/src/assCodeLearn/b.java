package assCodeLearn;

public class b {
	public static void main(String[] args) {
		try {
			q();
			System.out.println("a");

		}

		catch (Exception ex) {
			System.out.println("b");

		}
		finally {
			System.out.println("c");
		}
		System.out.println("d");

	}
	public static void q() {
		throw new Error();
	}

}
