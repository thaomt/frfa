package exercise_3.page;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class Cookiess{
	WebDriver driver;

	public Cookiess(WebDriver driver) {
		this.driver=driver;
	}
	public void getAllCookies() {
		Set<org.openqa.selenium.Cookie> cookie=driver.manage().getCookies();
		for(org.openqa.selenium.Cookie cookies: cookie) {
			String value="Name: "+cookies.getName()+"\n"
					+"Value: "+cookies.getValue()+"\n"
					+"Domain: "+cookies.getDomain()+"\n"
					+"Expiry: "+cookies.getExpiry();
					
			System.out.println(value);
			System.out.println("--------------");
		}
	}

}
