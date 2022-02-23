package ThaoMT8_Assigment_Day04.Exercise_1;

public class Student {
	private String name;
	public Student(String name) {
		this.name=name;
	}
	public Student() {
		name="unknow";
	}
	public void printName() {
		System.out.println(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	  

}
