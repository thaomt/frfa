package ThaoMT8_Assigment_Day04.Exercise_4;

public class Author {
	private String name;
	private String email;
	private char gender;
	
	public Author(String name,String email,char gender) {
		this.name=name;
		this.email=email;
		this.gender=gender;
	}
	public String toString() {
		String info="";
		info=getName() +" ("+ getGender()+")  at "+getEmail(); 
		return info;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	
	

}
