package exercise_4;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookie {
	WebDriver chromeDriver;
	String link = "http://automationpractice.com/index.php";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		chromeDriver.get(link);
	}

	@Test
	public void test() {
		for(org.openqa.selenium.Cookie cookie: chromeDriver.manage().getCookies()) {
			String value="Name: "+cookie.getName()+"\n"
					+"Value: "+cookie.getValue()+"\n"
					+"Domain: "+cookie.getDomain()+"\n"
					+"Expiry: "+cookie.getExpiry()+"\n"
					+"Secure: "+cookie.isSecure();
			System.out.println(value);
			System.out.println("--------------");
		}
	
		
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
