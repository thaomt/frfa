package exercise_2;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartCast {
	WebDriver chromeDriver;
	String smart = "https://www.walmart.com/ip/VIZIO-70-Class-4K-UHD-LED-SmartCast-Smart-TV-HDR-V-Series-V705-G3/936515428";
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		chromeDriver.get(smart);
	}
	@Test
	public void smartCart() {
		String titleProduct=chromeDriver.findElement(By.xpath("//h1[@class='f3 b lh-copy dark-gray mt1 mb2']")).getText();
		System.out.println(titleProduct);
		String price =chromeDriver.findElement(By.xpath("//div[@class='pt3 f4 light-gray']//span[@itemprop='price']")).getText();
		System.out.println(price);
		String shipInfo=chromeDriver.findElement(By.xpath("//div[@data-item-id='206705183']//div[@class='mt2 mb2']//span[@class='w_A w_C w_B mr1 mt1 ph1']")).getText();
		System.out.println(shipInfo);
		String comboBox=chromeDriver.findElement(By.xpath("//div[@class='pt3 f4 light-gray']//div[@class='b f4 gray lh-copy pt2-m flex fr-m tr']")).getText();
		System.out.println(comboBox);
		chromeDriver.findElement(By.xpath("//i[@class='ld ld-List mr3']"));
		chromeDriver.findElement(By.xpath("//i[@class='ld ld-Gift mr3']"));
		
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}
}
