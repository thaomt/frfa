package exercise_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Walmart {
	WebDriver chromeDriver;
	String walmart = "https://www.walmart.com/account/signup";
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		chromeDriver.get(walmart);
	}
	@Test
	public void walMart() {
		chromeDriver.findElement(By.name("firstName")).sendKeys("Thao");
		chromeDriver.findElement(By.name("lastName")).sendKeys("MT");
		chromeDriver.findElement(By.xpath("//*[@id='email-su']")).sendKeys("thao@gmail.com");
		chromeDriver.findElement(By.xpath("//*[@id='password-su']")).sendKeys("thaoXG1999");
		chromeDriver.findElement(By.cssSelector("#sign-up-form > .copy-mini > label")).click();		
		chromeDriver.findElement(By.xpath("//*[@id='sign-up-form']/button[1]"));
		chromeDriver.findElement(By.xpath("//*[@id='sign-up-form']/button[2]"));
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}
}
