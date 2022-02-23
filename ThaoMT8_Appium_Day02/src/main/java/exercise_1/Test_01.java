package exercise_1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Test_01 {
	AndroidDriver<WebElement> driver;
	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Redmi 9T");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("browserName","Chrome");
		capabilities.setCapability("chromedriverExecutable","C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, capabilities);
	}
	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.google.com.vn");
		Thread.sleep(3000);
		WebElement searchBox = driver.findElementByXPath("//input[@name='q']");
		//3. Send keys with value ="appium testing"
		searchBox.sendKeys("appium testing");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		//4. Click first result on google page
		driver.findElementByXPath("//a[contains(@href,'https://appium.io/')]").click();
		Thread.sleep(3000);
		//5: Verify page title. The page title should be “Appium: Mobile App Automation Made Awesome.”
		assertEquals(driver.getTitle(),"Appium: Mobile App Automation Made Awesome.");
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
