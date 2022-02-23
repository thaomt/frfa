package exercise_1;

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

public class Test_01 {
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
		//4: Click Điện Gia Dụng
		WebElement dien = driver.findElementsById("vn.tiki.app.tikiandroid.category2:id/tvName").get(4);
		dien.click();
		Thread.sleep(3000);
		driver.findElementById
		("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
		Thread.sleep(3000);
		//5: Select “Bán chạy”
		WebElement banchay = driver.findElementsByClassName("android.widget.TextView").get(6);
		banchay.click();
		Thread.sleep(3000);
		//6: Click first the product
		WebElement first = driver.findElementsById("vn.tiki.app.tikiandroid:id/tvName").get(2);
		first.click();
		// verify display
		Thread.sleep(3000);
		WebElement nameProduct = driver
				.findElementByXPath("//android.widget.TextView[@content-desc=\"pdp_product_name\"]");
		assertTrue(nameProduct.isDisplayed());
		Thread.sleep(3000);
		WebElement priceProduct = driver
				.findElementByXPath("//android.widget.TextView[@content-desc=\"pdp_current_price\"]");
		assertTrue(priceProduct.isDisplayed());
		Thread.sleep(5000);
		// 7: Scroll to Thông tin chi tiết
		MobileElement element = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector().text(\"Thông Tin Chi Tiết\"))"));
		Thread.sleep(5000);
		// 8: Verify product category display.
		WebElement categories = driver.findElementById
				("vn.tiki.app.tikiandroid.productDetail2:id/tvTitle");
		assertTrue(categories.isDisplayed());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
