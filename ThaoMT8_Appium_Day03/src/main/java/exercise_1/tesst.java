package exercise_1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class tesst {
	AndroidDriver<WebElement> driver;

	@BeforeMethod
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

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		//3: Click Danh Muc San Pham
		WebElement danhmuc = driver.findElementById("vn.tiki.app.tikiandroid:id/navCategories");
		danhmuc.click();
		Thread.sleep(3000);
		// 5: Scroll to panel “Laptop & Máy Vi Tính”
		MobileElement element2 = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector().text(\"Máy ảnh - Máy Quay Phim\"))"));
		Thread.sleep(5000);
		// theo list nhưng chưa click đc
		List<WebElement> listTextVoucher = driver.findElements(By.id("com.nct.shopiness:id/tvProduct"));
		System.out.println("size of List= " + listTextVoucher.size());
		String text = listTextVoucher.get(listTextVoucher.size() - 1).getText();
		System.out.println("text" + text);
		MobileElement elementToClick = (MobileElement) driver
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".resourceId(\"com.nct.shopiness:id/tvProduct\")).scrollIntoView("
						+ "new UiSelector().text(\"" + text + "\"));");
		elementToClick.click();
		// cach scroll khac
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Voucher tiền mặt trị giá 20K tại Grab\"));").click();
	

	// 6: Click to the “Laptop”
	WebElement laptop = driver.findElementsById("vn.tiki.app.tikiandroid.category2:id/tvContent")
			.get(6);laptop.click();Thread.sleep(2000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
