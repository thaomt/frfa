package exercise_4;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListDemo {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

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
		Select make=new Select(chromeDriver.findElement(By.className("form-control")));
		make.selectByValue("Monday");
		String expectValue="Day selected :- Monday";
		WebElement display=chromeDriver.findElement(By.className("selected-value"));
		String actualValue=display.getText();
		System.out.println(actualValue);
		assertEquals(actualValue,expectValue);
		
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
