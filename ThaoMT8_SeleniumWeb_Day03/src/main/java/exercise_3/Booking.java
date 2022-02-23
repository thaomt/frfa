package exercise_3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Booking {
	WebDriver chromeDriver;
	String booking = "https://www.booking.com/";
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		chromeDriver.get(booking);
	}
	@Test
	public void booking() {
		chromeDriver.findElement(By.xpath("//*[@id='b2indexPage']/header/nav[1]/div[2]/div[5]/a/span")).click();
		chromeDriver.findElement(By.xpath("//*[@id='username']")).sendKeys("thao@gmail.com");
		chromeDriver.findElement(By.xpath("//span[@class='bui-button__text']"));
		chromeDriver.findElement(By.xpath("//a[@title='Sign in with Facebook']//div[@class='access-panel__social-button-image']")).click();
	}
	@After
	public void tearDown() {
		//chromeDriver.quit();
	}

}
