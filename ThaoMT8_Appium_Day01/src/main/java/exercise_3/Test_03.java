package exercise_3;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Test_03 {
	@Test
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.shopstyle.activity.HomeActivity");
		capabilities.setCapability("appPackage", "com.shopstyle");
		capabilities.setCapability("deviceName", "Pixel 2 API 28 2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("automationName", "UIAutomator2");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
		//2: Click to the Not Now button.
		Thread.sleep(5000);
		driver.findElementById("com.shopstyle:id/skipText").click();
		//3: Click to the Shop Men.
		Thread.sleep(5000);
		driver.findElementById("com.shopstyle:id/btnMale").click();
		//4: Click to the Brands
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Brands\"]/android.widget.TextView").click();
		//5: Search “Aer” 
		Thread.sleep(5000);
		driver.findElementById("com.shopstyle:id/search_src_text").sendKeys("Aer");
		//click to the first item.
		Thread.sleep(5000);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView").click();
		Thread.sleep(3000);
		//6: Verify the Aer brands page display.(Add to my brands button, Newest tab, On Sale tab,Lowest price).
		Assert.assertTrue(driver.findElementById("com.shopstyle:id/linAddToBrand").isDisplayed());
		Assert.assertTrue(driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Newest\"]/android.widget.TextView").isDisplayed());
		Assert.assertTrue(driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"On Sale\"]/android.widget.TextView").isDisplayed());
		Assert.assertTrue(driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Lowest Price\"]/android.widget.TextView").isDisplayed());

		driver.quit();
	}

}
