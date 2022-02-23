package exercise_1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TikiTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void tiki() {
		// Test name: tiki
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://tiki.vn/");
		// 2 | setWindowSize | 1552x840 |
		driver.manage().window().setSize(new Dimension(1552, 840));
		// 3 | mouseOver | css=.FormSearch__Button-sc-1fwg3wo-3 |
		{
			WebElement element = driver.findElement(By.cssSelector(".FormSearch__Button-sc-1fwg3wo-3"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		// 4 | click | css=.FormSearch__Input-sc-1fwg3wo-2 |
		driver.findElement(By.cssSelector(".FormSearch__Input-sc-1fwg3wo-2")).click();
		// 5 | type | css=.FormSearch__Input-sc-1fwg3wo-2 | laptop dell
		driver.findElement(By.cssSelector(".FormSearch__Input-sc-1fwg3wo-2")).sendKeys("laptop dell");
		// 6 | sendKeys | css=.FormSearch__Input-sc-1fwg3wo-2 | ${KEY_ENTER}
		driver.findElement(By.cssSelector(".FormSearch__Input-sc-1fwg3wo-2")).sendKeys(Keys.ENTER);
		// 7 | mouseOver | css=.sort-list > a:nth-child(3) |
		{
			WebElement element = driver.findElement(By.cssSelector(".sort-list > a:nth-child(3)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		// 8 | click | css=.product-item:nth-child(2) .styles__StyledQtySold-sc-732h27-2
		// |
		driver.findElement(By.cssSelector(".product-item:nth-child(2) .styles__StyledQtySold-sc-732h27-2")).click();
		// 9 | click | css=.header > .title |
		driver.findElement(By.cssSelector(".header > .title")).click();
		// 10 | click | css=.product-price__current-price |
		driver.findElement(By.cssSelector(".product-price__current-price")).click();
	}
}
