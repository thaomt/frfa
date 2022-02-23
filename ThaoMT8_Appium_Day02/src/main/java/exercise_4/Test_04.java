package exercise_4;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Test_04 {
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
		//4: Click Danh Muc San Pham
		WebElement danhmucSP = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Danh mục\"]/android.widget.ImageView"));
		danhmucSP.click();
		Thread.sleep(3000);
		// 5: Click Laptop – May Vi Tinh
		WebElement laptopViTinh = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[15]/android.widget.ImageView"));
		laptopViTinh.click();
		Thread.sleep(1000);
		driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
		Thread.sleep(5000);
		//6: Click to the Laptop
		WebElement laptop = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView"));
		laptop.click();
		Thread.sleep(3000);
		//7: Click first the product 
		WebElement firstProduct = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.widget.TextView"));
		firstProduct.click();		
		//Verify the product name, product price and “Chọn mua” button must be displayed.
		Thread.sleep(3000);
		WebElement nameProduct = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"pdp_product_name\"]"));
		assertTrue(nameProduct.isDisplayed());
		Thread.sleep(3000);
		WebElement priceProduct=driver.findElementByXPath("//android.widget.TextView[@content-desc=\"pdp_current_price\"]");
		assertTrue(priceProduct.isDisplayed());
		Thread.sleep(3000);
		WebElement chonMua = driver.findElementById("vn.tiki.app.tikiandroid.productDetail2:id/pdp3_main_cta_button");
		assertTrue(chonMua.isDisplayed());
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
