package exercise_3;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrames {
	WebDriver chromeDriver;
	String link = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width";

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
		chromeDriver.switchTo().frame("iframeResult");
		WebElement iframeElement=chromeDriver.findElement(By.xpath("//iframe[@src='demo_iframe.htm']"));
		chromeDriver.switchTo().frame(iframeElement);
		WebElement frame1Heading = chromeDriver.findElement(By.xpath("/html/body/h1"));
		String actualValue = frame1Heading.getText();
		String expectValue = "This page is displayed in an iframe";
		System.out.println(actualValue);
		assertEquals(actualValue, expectValue);
		chromeDriver.switchTo().defaultContent();
	}

	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
