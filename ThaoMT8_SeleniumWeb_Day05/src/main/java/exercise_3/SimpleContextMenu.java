package exercise_3;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleContextMenu {
	WebDriver chromeDriver;
	WebDriverWait wait;
	String link = "http://demo.guru99.com/test/simple_context_menu.html";

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
	public void test() throws HeadlessException, AWTException, InterruptedException, IOException {
		WebElement button = chromeDriver.findElement(By.xpath("//*[@id='authentication']/span"));
		WebElement edit=chromeDriver.findElement(By.xpath("//*[@id='authentication']/ul/li[1]/span"));
		Actions builder = new Actions(chromeDriver);
		wait = new WebDriverWait(chromeDriver, 5);
		if (button.isDisplayed()) {
			System.out.println("“Right click me” displayed");
			builder.contextClick(button).moveToElement(edit).click().perform();
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = chromeDriver.switchTo().alert();
			Thread.sleep(2000);			
			BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		    ImageIO.write(image, "png", new File("..\\ThaoMT8_Assignment_Day05\\src\\main\\java\\exercise_3\\test.png"));		    
		    alert.accept();
		} else {
			System.out.println("Not displayed");
		}

	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}


}
