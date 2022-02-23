package ThaoMT8_Assigment_Day07.ex3;

public class TestClass {

	public static void main(String[] args) {
			
		Shape s1 = new Circle(5.5, "pink", true);  		   
		Circle c1 = (Circle)s1; 
		System.out.println(c1);
		System.out.println("Color: "+c1.getColor());
		System.out.println("Filled: "+c1.isFilled());
		System.out.println("Radius: "+c1.getRadius());
		System.out.println("Area: "+c1.getArea());
		System.out.println("Perimeter: "+c1.getPerimeter());
		   
		Shape s3 = new Rectangle(1.0, 2.0, "pink", true);  		   
		Rectangle r1 = (Rectangle)s3;
		System.out.println(r1);
		System.out.println("Color: "+r1.getColor());
		System.out.println("Lenght: "+r1.getLenght());
		System.out.println("Width: "+r1.getWidth());
		System.out.println("Filled: "+c1.isFilled());
		System.out.println("Area: "+r1.getArea());
		System.out.println("Perimeter: "+r1.getPerimeter());
		   
		Shape s4 = new Square(2.0,"pink", true);     
		Rectangle r2 = (Rectangle)s4;
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println("Area: "+sq1.getArea());
		System.out.println("Color: "+sq1.getColor());
		System.out.println("Filled: "+c1.isFilled());
		System.out.println("Side: "+sq1.getSide());

	}

}
