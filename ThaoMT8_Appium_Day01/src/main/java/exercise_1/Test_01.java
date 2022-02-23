package exercise_1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
// dumpsys window windows|grep -E 'mCurrentFocus'
public class Test_01 {
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.shopstyle.activity.HomeActivity");
		capabilities.setCapability("appPackage", "com.shopstyle");
		capabilities.setCapability("deviceName", "d3b111c30121");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("automationName", "UIAutomator2");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
		// 2: Click to the Not Now button.
		Thread.sleep(5000);
		driver.findElementById("com.shopstyle:id/skipText").click();
		// 3: Click to the Shop Men.
		Thread.sleep(3000);
		driver.findElementById("com.shopstyle:id/btnMale").click();
		//4: Click to the Shoes
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Shoes\"]").click();
		// 5: Click to the Lowest Price tab
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Lowest Price\"]/android.widget.TextView").click();
		//6: Click to the first product
		Thread.sleep(3000);
		driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"ShopStyle\"])[1]").click();
		//Verify product name
		Thread.sleep(3000); 
		Assert.assertEquals(driver.findElementById("com.shopstyle:id/productTitle").getText(), "STICKER CABANA Shoe Sticker");
		//Verify product price
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElementById("com.shopstyle:id/sale_price").getText(), "$2.39");
		//Verify Buy now button
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElementById("com.shopstyle:id/buyButton").getText(), "BUY NOW AT TILLYS");
		driver.quit();

		
	}
}
