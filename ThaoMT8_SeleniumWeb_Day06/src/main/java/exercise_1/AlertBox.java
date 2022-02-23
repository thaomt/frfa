package exercise_1;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";

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
	public void test() throws IOException, HeadlessException, AWTException, InterruptedException {
		WebElement button=chromeDriver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
		if(button.isDisplayed()) {
			button.click();
			try {
				Alert alert=chromeDriver.switchTo().alert();
				String text=alert.getText();
				System.out.println(text);
				Thread.sleep(2000);			
				BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			    ImageIO.write(image, "png", new File("..\\ThaoMT8_Assignment_Day06\\src\\main\\java\\exercise_1\\test.png"));		    
			    alert.accept();
			}catch(NoAlertPresentException e) {
				e.printStackTrace();		
			}
		}else {
			System.out.println("Button is not display");
		}		
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}


}
