package exercise_1.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AppiumBase {
	public static AndroidDriver<WebElement> driver;
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Redmi 9T");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "vn.tiki.app.tikiandroid");
		capabilities.setCapability("appActivity", "vn.tiki.android.shopping.homeV3.HomeActivity");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("autoAcceptAlerts", true);
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, capabilities);
	}
	public void teardown() {
		driver.quit();
	}
	public static AndroidDriver<WebElement> getDriver(){
		return driver;
	}
}
