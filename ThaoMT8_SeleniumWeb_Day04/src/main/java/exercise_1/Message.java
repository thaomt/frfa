package exercise_1;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Message {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";

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
		WebElement input = chromeDriver.findElement(By.xpath("//input[@id='user-message']"));
		String expectValue="Automation Tester";
		input.sendKeys(expectValue);
		WebElement message = chromeDriver.findElement(By.xpath("//button[@onclick='showInput();']"));
		message.click();
		WebElement verifyMessage = chromeDriver.findElement(By.xpath("//div[@id='user-message']"));
		String actualValue = verifyMessage.getText();
		System.out.println(actualValue);
		assertEquals(actualValue,"Your Message: "+expectValue);
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}


}
