package exercise_4;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testJSSCRIPT {
	WebDriver driver;
	String link = "http://automationpractice.com/index.php?controller=authentication";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(link);
		

	}
	@Test
	public void test() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				executor.executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		}catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		WebElement dresses=driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[2]/a"));
		if (dresses.isEnabled() && dresses.isDisplayed()) {		
			System.out.println("Dress is display");
		} else {
			System.out.println("No display");
		}
		WebElement tops=driver.findElement(By.xpath("//*[@id='categories_block_left']/div/ul/li[1]/a"));
		try {
			if (tops.isEnabled() && tops.isDisplayed()) {
				executor.executeScript("arguments[0].click();", tops);
			} else {
				System.out.println("Unable to click on element");
			}
		}catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		this.movesBack();
		System.out.println(driver.getTitle());
		this.moveForward();
		System.out.println(driver.getTitle());
		
		WebElement tShirts=driver.findElement(By.xpath("//*[@id='categories_block_left']/div/ul/li[1]/a"));
		tShirts.click();
		Set<Cookie> cookie=driver.manage().getCookies();
		for(Cookie cookies: cookie) {
			String value="Name: "+cookies.getName()+"\n"
					+"Value: "+cookies.getValue()+"\n"
					+"Domain: "+cookies.getDomain()+"\n"
					+"Expiry: "+cookies.getExpiry()+"\n"
					+"Secure: "+cookies.isSecure();
			System.out.println(value);
			System.out.println("--------------");
		}
	
		
		
	}
	public void movesBack() {
		driver.navigate().back(); 
	}
	public void  moveForward() {
		driver.navigate().forward(); 
		
	}
	
	

}
