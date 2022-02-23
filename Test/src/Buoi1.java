
public class Buoi1 {
	//Class variable at class level ( static variable, field)
	// Constant
	public static final int CURRENT_YEAR=2021;
	
	//
	static int year1=2;
	//
	// java instance variable
	private int year=2020;
	
	public void print(int s/*Parameter variable*/) {
		//local variable
		int year=2000;
		s=s*2;
		year1=year1*2;
		System.out.println(year);
		//System.out.println(this.year);// goi toi bien year instance
	}
	public static void main(String [] args) {
		Buoi1 check = new Buoi1();
		int year2=3;		
		check.print(year2);
		System.out.println(Buoi1.CURRENT_YEAR);
		System.out.println(year2);// in ra gia tri year2 luon
		System.out.println(year1);
		System.out.println(check.year);
	}

}
