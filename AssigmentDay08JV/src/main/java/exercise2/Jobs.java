package exercise2;

public class Jobs {
	private String employer;
	private Duration duration;
	private String title;
	private String description;
	public Jobs(String employer,Duration duration,String title,String description) {
		this.employer = employer;
		this.duration = duration;
		this.title = title;
		this.description = description;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	@Override
//	public String toString() {
//		return "Jobs [employer=" + employer + ", duration=" + duration + ", title=" + title + ", description="
//				+ description + "]";
//	}
	
	
	

}
