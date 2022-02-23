package ThaoMT8_Assigment_Day07.ex3;

public class Square extends Rectangle{
	
	
	public Square() {
		super();
	}

	public Square(double side) {
		super(side,side);
	}
	public Square(double side,String color, boolean filled) {
		super(side,side);
		this.color=color;
		this.filled=filled;
	}

	public void setSide(double side) {
		this.setLenght(side);
	}
	public double getSide() {
		return super.getLenght();
	}

	 @Override
	public void setWidth(double width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}

	@Override
	public void setLenght(double lenght) {
		// TODO Auto-generated method stub
		super.setLenght(lenght);
	}

	@Override
	  public String toString() {
	    return "Square ["+super.toString()+"]";
	  }
	
	
	

}
