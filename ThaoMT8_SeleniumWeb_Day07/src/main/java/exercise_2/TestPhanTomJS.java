package exercise_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPhanTomJS {
	static WebDriver driver;
	@BeforeTest
	public void set() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true); 
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:\\Users\\thaoc\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		driver = new PhantomJSDriver(caps);
	}
	@Test
	public void testGooglePageTitleInChrome() {
	driver.get("http://www.google.com");
	String strPageTitle = driver.getTitle();
	Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	System.out.println(strPageTitle);
	}
	@Test
	public void testSearchGoogle() {
		System.out.println("Opening Google..");
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
		driver.findElement(By.name("q")).submit();
	}
	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
