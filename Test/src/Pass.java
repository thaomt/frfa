
public class Pass {
	static int j=20;

	public static void main(String[] args) {
		int i=10;
		Pass p = new Pass();
		p.amethod(i);
		int x,a=6,b=7;
		x=a++ + b++;
		System.out.println(x+""+a+""+b);
		
		System.out.println(i); 
		System.out.println(j);

	}
	
	public void amethod(int x) {
		x=x*2; 
		j=j*2;
	}
}
