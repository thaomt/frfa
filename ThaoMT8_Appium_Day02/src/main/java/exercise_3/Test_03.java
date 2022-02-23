package exercise_3;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Test_03 {
	AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Redmi 9T");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("appPackage", "com.example.hybridtestapp");
		capabilities.setCapability("appActivity", "com.example.hybridtestapp.MainActivity");
		capabilities.setCapability("autoAcceptAlerts", true);
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, capabilities);
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Tiếp tục\")").click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//android.widget.Button[@text='OK']")).click();
		Thread.sleep(4000);
		List<WebElement> listTextBox = driver.findElements(By.className("android.widget.EditText"));
		//2: Input FirstName, LastName, Age, UserName, Password
		listTextBox.get(0).sendKeys("mai");
		listTextBox.get(1).sendKeys("thao");
		listTextBox.get(2).sendKeys("22");
		listTextBox.get(3).sendKeys("thaomt");
		listTextBox.get(4).sendKeys("12345");
		//3: Click Register
		driver.findElement(By.xpath(".//android.widget.Button[@text='Register']")).click();
		String textExpect = "Registration Success!\r\n"
				+ "Welcome mai";
		Thread.sleep(2000);
		WebElement textActual = driver.findElementByClassName("android.view.View");
		//4: Verify FirstName on the screen.
		assertEquals(textActual.getText(), textExpect);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
