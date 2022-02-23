package exercise_4;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchFrame {
	WebDriver chromeDriver;
	String link = "https://demoqa.com/frames";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		chromeDriver.get(link);
	}

	@Test
	public void test() {
		chromeDriver.switchTo().frame("frame1");
		WebElement frame1Heading = chromeDriver.findElement(By.id("sampleHeading"));
		String actualValue1 = frame1Heading.getText();
		String expectValue = "This is a sample page";
		assertEquals(actualValue1, expectValue);
		chromeDriver.switchTo().defaultContent();
		
		chromeDriver.switchTo().frame("frame2");
		WebElement frame2Heading = chromeDriver.findElement(By.id("sampleHeading"));
		String actualValue2 = frame2Heading.getText();
		assertEquals(actualValue2, expectValue);
		chromeDriver.switchTo().defaultContent();
	}

	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
