package exercise_2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Test_02 {
	@Test
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.shopstyle.activity.HomeActivity");
		capabilities.setCapability("appPackage", "com.shopstyle");
		capabilities.setCapability("deviceName", "Pixel 2 API 28 2");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("automationName", "UIAutomator2");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
		//2: Click to the Not Now button.
		Thread.sleep(5000);
		driver.findElementById("com.shopstyle:id/skipText").click();
		//3: Click to the Shop Men.
		Thread.sleep(3000);
		driver.findElementById("com.shopstyle:id/btnMale").click();
		//4: Click to the Categories.
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Categories\"]/android.widget.TextView").click();
		WebElement parentElement = driver.findElementByClassName("androidx.recyclerview.widget.RecyclerView");
		Thread.sleep(4000);
		List<WebElement> childElements = parentElement.findElements(By.className("android.widget.TextView"));		
		//5: Verify Category display: All Men, Clothing, Bags, Shoes, Accessories and Grooming.
		Thread.sleep(3000);
		Assert.assertTrue(childElements.get(1).isDisplayed());	
		Thread.sleep(3000);
		Assert.assertTrue(childElements.get(2).isDisplayed());		
		Thread.sleep(3000);
		Assert.assertTrue(childElements.get(3).isDisplayed());
		Thread.sleep(3000);
		Assert.assertTrue(childElements.get(4).isDisplayed());		
		Thread.sleep(3000);
		Assert.assertTrue(childElements.get(5).isDisplayed());
		Thread.sleep(3000);
		Assert.assertTrue(childElements.get(6).isDisplayed());
		driver.quit();

	}
		
	


}
