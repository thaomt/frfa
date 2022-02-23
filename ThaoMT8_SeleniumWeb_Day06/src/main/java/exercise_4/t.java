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

public class t {
	WebDriver driver;
	String link = "http://automationpractice.com/index.php?controller=contact";


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(link);
	}

	@Test
	public void test() {
		WebElement button1 = driver.findElement(By.xpath("//*[@id='id_contact']"));

		button1.findElement(By.xpath("//option[. = 'Customer service']")).click();

		WebElement button2 = driver.findElement(By.xpath("//input[@id='email']"));
		if (button2.isDisplayed()) {
			button2.sendKeys("thao@gmail.com");
		} else {
			System.out.println("Email address is not display");
		}
		WebElement button3 = driver.findElement(By.xpath("//input[@id='id_order']"));
		if (button3.isDisplayed()) {
			button3.sendKeys("Faded Short Sleeve T-shirts");
		} else {
			System.out.println("Order reference is not display");
		}
	    driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\Users\\thaoc\\Downloads\\testParallel.txt");

		WebElement button5 = driver.findElement(By.xpath("//textarea[@id='message']"));
			button5.sendKeys("I hope soon get more information about Faded Short Sleeve T-shirts");
		
		WebElement button6 = driver.findElement(By.xpath("//button[@id='submitMessage']"));
		if (button6.isDisplayed()) {
			button6.click();
		} else {
			System.out.println("Button send is not display");
		}	
		String actualValue = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		System.out.println(actualValue);
		assertEquals(actualValue, "Your message has been successfully sent to our team.");

	}

	@After
	public void tearDown() {
		// chromeDriver.quit();
	}

}
