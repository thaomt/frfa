package exercise_2;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test_02 {
	AndroidDriver<WebElement> driver;
	@BeforeMethod
	public void setup() throws MalformedURLException, InterruptedException {
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
		driver.get("https://shopee.vn");
		Thread.sleep(10000);
		//driver.findElementByXPath("//android.view.View[@content-desc=\"ShopeeFood - Giảm 99K ShopeeFood - Giảm 99K\"]/android.view.View[2]").click();
		//3: Click to the “Shopee Mall”
		MobileElement elementToClick = (MobileElement) driver
				.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().textContains(\"Shopee Mall\"))");
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true).instance(1)).setAsHorizontalList()" +
		         ".scrollIntoView(new UiSelector().text(\"Shopee Mall\"))"));
		Thread.sleep(5000);
		element.click();
		//4: Click to the “Nhà Cửa & Đời Sống”
		WebElement house=driver.findElementByXPath("//*[@class='android.view.View'][contains(text(),'Nhà Cửa & Đời Sống')]");
		house.click();
		Thread.sleep(5000);
		//5: Click first result on Nhà Cửa & Đời Sống page.
		List<WebElement> listItem=driver.findElementsByXPath("//div[@class='_10Wbs- _5SSWfi UjjMrh']");
		listItem.get(0).click();
		Thread.sleep(5000);
		WebElement productName=driver.findElementByXPath("//div[@class='attM6y']/span");
		WebElement productPrice=driver.findElementByXPath("//div[@class='Ybrg9j']");
		WebElement productImage=driver.findElementByXPath("//div[@class='ApRQXC']");
		Thread.sleep(5000);
		//6: Verify product image, product name and product price must be displayed.
		assertTrue(productName.isDisplayed());
		assertTrue(productPrice.isDisplayed());
		assertTrue(productImage.isDisplayed());	
	}
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

}
