
public class ExperienceCandidate extends Candidate{
	private double ExpInYear;
	private String ProSkill;
	public ExperienceCandidate() {
    }
 
    public ExperienceCandidate(String FirstName , String LastName,String Phone, String Email,double ExpInYear,String ProSkilla) {
        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.ExpInYear = ExpInYear;
        this.ProSkill=ProSkill;
    }
 
    
	public double getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(double expInYear) {
		ExpInYear = expInYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	public void register() {
		
	}

}
