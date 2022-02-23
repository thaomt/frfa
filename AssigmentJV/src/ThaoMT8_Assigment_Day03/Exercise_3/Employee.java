package ThaoMT8_Assigment_Day03.Exercise_3;

public class Employee {
	private String name;
	private int year_of_joining; 
	private double salary; 
	private String address;
	public Employee(String name,int year_of_joining,String address) {
		this.name=name;
		this.year_of_joining=year_of_joining;
		this.address=address;
	}
	public void printInfo() {
		System.out.println(getName()+"    "+getYear_of_joining()+"    "+getAddress());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear_of_joining() {
		return year_of_joining;
	}
	public void setYear_of_joining(int year_of_joining) {
		this.year_of_joining = year_of_joining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
