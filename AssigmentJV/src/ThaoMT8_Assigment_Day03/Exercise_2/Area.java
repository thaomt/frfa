package ThaoMT8_Assigment_Day03.Exercise_2;

public class Area {
	private int length;
	private int breadth;
	public Area(int length, int breadth) {
		this.length=length;
		this.breadth=breadth;	
	}
	public void returnArea() {
		
		System.out.println("The area of a rectangle: " +getLength()*getBreadth());
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	

}
