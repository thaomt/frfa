package exercise_2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Window {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/window-popup-modal-demo.html";

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\thaoc\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		chromeDriver = new FirefoxDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		chromeDriver.get(link);
	}

	@Test
	public void test() {
		String parentID = chromeDriver.getWindowHandle();
		System.out.println("id: "+parentID);
		/*WebElement button1 = chromeDriver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']"));
		if (button1.isDisplayed()) {
			button1.click();
			String childWindow1 = chromeDriver.getWindowHandles().toArray()[1].toString();
			chromeDriver.switchTo().window(childWindow1);
			System.out.println("Title of childWindow1 : " + chromeDriver.getTitle());
			chromeDriver.close();
			chromeDriver.switchTo().window(parentID);
		}else {
			System.out.println("Button 1 is not display");
		}
		WebElement button2 = chromeDriver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Facebook']"));
		if (button2.isDisplayed()) {
			button2.click();
			String childWindow2 = chromeDriver.getWindowHandles().toArray()[1].toString();
			chromeDriver.switchTo().window(childWindow2);
			System.out.println("Title of childWindow2 : " + chromeDriver.getTitle());
			chromeDriver.close();
			chromeDriver.switchTo().window(parentID);			
		}else {
			System.out.println("Button 2 is not display");
		}*/
	}

	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
