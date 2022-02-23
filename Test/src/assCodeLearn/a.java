package assCodeLearn;

public class a {
public static void m () throws Exception{
		
		try {
			throw new Exception();
		}
		finally {
			System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		try {
			m();
		}catch(Exception e) {
			System.out.println("exception");
		}
		System.out.println("finished");

	}
	
}