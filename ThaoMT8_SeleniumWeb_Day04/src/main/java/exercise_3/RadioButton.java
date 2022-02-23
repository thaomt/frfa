package exercise_3;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";

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
		WebElement choice1=chromeDriver.findElement(By.xpath("//div[@class='panel-body']/div[1]/label[1]"));
		if(!choice1.isSelected()) {
			choice1.click();
		}
		WebElement choice2=chromeDriver.findElement(By.xpath("//div[@class='panel-body']/div[2]/label[2]"));
		if(!choice2.isSelected()) {
			choice2.click();
		}
		String expectValue="Sex : Male\n"
				+ "Age group: 5 - 15";
		WebElement click=chromeDriver.findElement(By.xpath("//button[@onclick='getValues();']"));
		click.click();
		WebElement mess=chromeDriver.findElement(By.xpath("//p[@class='groupradiobutton']"));
		String actualValue=mess.getText();
		System.out.println(actualValue);
		assertEquals(actualValue,expectValue);
		
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
