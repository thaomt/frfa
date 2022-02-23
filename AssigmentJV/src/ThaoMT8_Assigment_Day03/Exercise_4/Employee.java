package ThaoMT8_Assigment_Day03.Exercise_4;

public class Employee {
	private double number_of_hours;
	private double salary;
	public Employee(double number_of_hours,double salary) {
		this.number_of_hours=number_of_hours;
		this.salary=salary;
	}
	public double AddSal() {
		if(salary<500) {
			salary = salary + 10;
		}
		return salary;
	}
	public double AddWork() {
		if(number_of_hours > 6) {
			salary = salary + 5;
		}
		return salary;
	}
   public double getInfo(double number_of_hours,double salary) {
		
		return salary;
	}
   public double getNumber_of_hours() {
		return number_of_hours;
	}
	public void setNumber_of_hours(double number_of_hours) {
		this.number_of_hours = number_of_hours;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
