package exercise_3;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckContact {
	static PhantomJSDriver driver;

	@BeforeTest
	public void set() {
		System.setProperty("phantomjs.binary.path",
				"C:\\Users\\thaoc\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		driver = new PhantomJSDriver();
	}
	@Test
	public void testGooglePageTitleInChrome() {
		driver.get("http://automationpractice.com/index.php?controller=contact");
		
		WebElement subjectHeading = driver.findElement(By.xpath("//*[@id='id_contact']"));
		subjectHeading.findElement(By.xpath("//option[. = 'Customer service']")).click();

		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email']"));
		if (emailAddress.isDisplayed()) {
			emailAddress.sendKeys("thao@gmail.com");
		} else {
			System.out.println("Email address is not display");
		}
		
		WebElement orderReference = driver.findElement(By.xpath("//input[@id='id_order']"));
		if (orderReference.isDisplayed()) {
			orderReference.sendKeys("Faded Short Sleeve T-shirts");
		} else {
			System.out.println("Order reference is not display");
		}
		
		WebElement attachFile=driver.findElement(By.xpath("//input[@id='fileUpload']"));
		attachFile.sendKeys("..\\ThaoMT8_Assignment_Day07\\src\\main\\java\\exercise_3\\test.png");
		
		WebElement message = driver.findElement(By.xpath("//textarea[@id='message']"));
		message.sendKeys("I hope soon get more information about Faded Short Sleeve T-shirts");
		
		WebElement sendButton = driver.findElement(By.xpath("//button[@id='submitMessage']"));
		if (sendButton.isDisplayed()) {
			sendButton.click();
		} else {
			System.out.println("Button send is not display");
		}
		
		String actualValue = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
		System.out.println(actualValue);
		assertEquals(actualValue, "Your message has been successfully sent to our team.");

	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
