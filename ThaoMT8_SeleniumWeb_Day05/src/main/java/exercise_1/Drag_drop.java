package exercise_1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_drop {
	WebDriver chromeDriver;
	String link = "http://demo.guru99.com/test/drag_drop.html";

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
		WebElement elementSource=chromeDriver.findElement(By.xpath("//*[@id='fourth'][1]"));
		WebElement elementTarget=chromeDriver.findElement(By.xpath("//*[@id='amt7']/li"));
		Actions builder=new Actions(chromeDriver);
		builder.dragAndDrop(elementSource, elementTarget).perform();	
		
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
