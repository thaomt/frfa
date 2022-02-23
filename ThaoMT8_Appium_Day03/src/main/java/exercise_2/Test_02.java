package exercise_2;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
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
		// 4: Scroll to “Hàng Quốc Tế” in Left menu
		MobileElement element1 = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector().text(\"Hàng Quốc Tế\"))"));
		element1.click();
		Thread.sleep(5000);
		// 5: Scroll to panel “Laptop & Máy Vi Tính”
		MobileElement element2 = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(1))"
						+ ".scrollIntoView(new UiSelector().text(\"Laptop & Máy Vi Tính\"))"));
		Thread.sleep(5000);
		//6: Click to the “Laptop”
		WebElement laptop=driver.findElementsById("vn.tiki.app.tikiandroid.category2:id/tvName").get(10);
		laptop.click();
		Thread.sleep(2000);
		driver.findElementById
		("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
		Thread.sleep(3000);
		// 7: Click to the first product
		WebElement first=driver.findElementsById("vn.tiki.app.tikiandroid:id/tvName").get(0);
		first.click();
		Thread.sleep(5000);
		// 8: Scroll to Thông tin chi tiết
		MobileElement element3 = (MobileElement) driver.findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
					+ ".scrollIntoView(new UiSelector().text(\"Thông Tin Chi Tiết\"))"));
		// 9: Verify
		Thread.sleep(3000);
		WebElement categories = driver.findElementById
				("vn.tiki.app.tikiandroid.productDetail2:id/tvTitle");
		assertTrue(categories.isDisplayed());
		Thread.sleep(3000);
		WebElement thuonghieu = driver.findElementsById
				("vn.tiki.app.tikiandroid.productDetail2:id/tvName").get(0);
		assertTrue(thuonghieu.isDisplayed());
		Thread.sleep(3000);
		WebElement xuatxu = driver.findElementsById
				("vn.tiki.app.tikiandroid.productDetail2:id/tvName").get(1);
		assertTrue(xuatxu.isDisplayed());
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
