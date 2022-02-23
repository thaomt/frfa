package ThaoMT8_Assigment_Day07.ex2;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String first;
	private String last;
	private String email;
	public Student(String first,String last,String email) {
		this.first=first;
		this.last=last;
		this.email=email;
		
	}
	@Override
	public String toString() {
		return "Student:\n"+"First name: "+first+"\nLast name: "+last+"\nEmail: "+email;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
