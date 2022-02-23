package ThaoMT8_Assigment_Day04.Exercise_3;

public class CharSequenceImplement implements CharSequence{
	
	private String s;
	public CharSequenceImplement(String s) {
		this.s = s;
	}

	@Override
	public int length() {
		return getS().length();
	}
	@Override
	public char charAt(int index) {
		return getS().charAt(s.length() - 1 - index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
	    return getS().subSequence(start, end);
		
	}
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
