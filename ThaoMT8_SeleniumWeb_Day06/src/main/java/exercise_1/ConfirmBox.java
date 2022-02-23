package exercise_1;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmBox {
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

	@Test()
	public void test() {
		this.testConfirm();
		this.testAlert();
	}
	public void testConfirm() {
		WebElement button=chromeDriver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
		if(button.isDisplayed()) {
			button.click();
			try {
				Alert alert=chromeDriver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				String expectValue="You pressed OK!";
				WebElement message=chromeDriver.findElement(By.xpath("//p[@id='confirm-demo']"));
				String actualValue=message.getText();
				System.out.println(actualValue);
				assertEquals(expectValue,actualValue);
			}catch(NoAlertPresentException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Button is not display");
		}
		
	}
	public void testAlert() {
		WebElement button=chromeDriver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
		if(button.isDisplayed()) {
			button.click();
			try {
				Alert alert=chromeDriver.switchTo().alert();
				alert.sendKeys("Mai Thi Thao");
				alert.accept();
				String expectValue="You have entered 'Mai Thi Thao' !";
				WebElement message=chromeDriver.findElement(By.xpath("//p[@id='prompt-demo']"));
				String actualValue=message.getText();
				System.out.println(actualValue);
				assertEquals(expectValue,actualValue);	
				
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
