package testQUiz;

public class testQuiz {
	public testQuiz(){
		System.out.println("No-Arg Constructor");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="hii";
		String s2="hii";
		String s3= new String("hii");
		System.out.println("test 1: "+(s1==s2));
		System.out.println("test 2: "+(s2==s3));
		System.out.println("test 3: "+(s3.equals(s1)));
		System.out.println(s1.substring(2, 2));

//		public static void main(String[] args) {
//			try {
//	            String message = "Do exercise 1";
//	            throw new Exception(message);
//	        } catch (Exception e) {
//	            System.out.println(e.getMessage());
//	        } finally {
//	            System.out.println("This is finally block ");
//	        }
	//
//		}
		
	}

}


