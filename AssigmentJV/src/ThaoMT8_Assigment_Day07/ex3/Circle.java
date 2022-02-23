package ThaoMT8_Assigment_Day07.ex3;


public class Circle extends Shape{
	protected double radius;
	

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius ,String color, boolean filled) {
		super(color, filled);
		this.radius=radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	double getArea() {
		return Math.PI*Math.pow(getRadius(),2);
	}

	@Override
	double getPerimeter() {
		return 2*Math.PI*getRadius();
	}

	@Override
	public String toString() {
		return "Circle["+super.toString()+", radius="+radius+","+"]";
	}
	
	

}
