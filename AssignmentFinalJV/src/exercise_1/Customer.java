package exercise_1;

public class Customer {
	private String name;
	private boolean member=false;
	private String memberType;
	public Customer(String name) {
		this.name=name;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getName() {
		return name;
	}
	public boolean isMember() {
		return member;
	}
	public void setMember(boolean member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Name: " + name + "\nMember: " + isMember() + "\nType: " + getMemberType() ;
	}
	
	
}
