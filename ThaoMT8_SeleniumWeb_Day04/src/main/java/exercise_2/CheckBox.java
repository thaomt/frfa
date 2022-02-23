package exercise_2;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";

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
		WebElement checkBox=chromeDriver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		if(!checkBox.isSelected()) {
			checkBox.click();
		}
		String expectValue="Success - Check box is checked";
		WebElement check=chromeDriver.findElement(By.xpath("//div[@id='txtAge']"));
		String actualValue=check.getText();
		System.out.println(actualValue);
		assertEquals(actualValue,expectValue);	
	}
	@After
	public void tearDown() {
		chromeDriver.quit();	
	}
	

}
