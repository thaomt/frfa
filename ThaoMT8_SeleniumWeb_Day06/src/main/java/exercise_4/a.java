package exercise_4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//
public class a {
	WebDriver driver;
	String link = "https://www.monsterindia.com/seeker/registration?r=1508505222&src=";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(link);
	}
//input[@id='fileUpload']
	@Test
	public void test() {
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\thaoc\\Downloads\\testParallel.txt");
System.out.println("done");
	}

}
