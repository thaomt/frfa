package ThaoMT8_Assigment_Day07.ex3;

public class Rectangle extends Shape{
	protected double width;
	protected double lenght;
	public Rectangle() {
		super();
	}
	public Rectangle(double width, double lenght) {
		super();
		this.width = width;
		this.lenght = lenght;
	}
	


	public Rectangle(double width, double lenght,String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.lenght = lenght;
		
	}
	@Override
	double getArea() {
		return getWidth()*getLenght();
	}

	@Override
	public String toString() {
		return "Rectangle ["+super.toString()+"]"+", width=" + width + ", lenght=" + lenght +"]";
	}
	@Override
	double getPerimeter() {
		return 2*(getWidth()+getLenght());
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLenght() {
		return lenght;
	}
	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

}
