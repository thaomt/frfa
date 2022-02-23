package exercise_1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {
	// ThreadLocal will keep local copy of driver
		public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

		@BeforeTest
		// Parameter will get browser from testng.xml on which browser test to run
		@Parameters({ "platform", "browser"})
		public void beforeClass(String platform, String browser) throws MalformedURLException {
			DesiredCapabilities caps = new DesiredCapabilities();
			RemoteWebDriver driver = null;
			// Platform
			if (browser.equalsIgnoreCase("Windows")) {
				caps.setPlatform(Platform.WINDOWS);
			}
			if (browser.equalsIgnoreCase("MAC")) {
				caps.setPlatform(Platform.MAC);
			}
			// Browser
			if (browser.equalsIgnoreCase("Internet Explorer")) {
				caps = DesiredCapabilities.internetExplorer();
				driver = new RemoteWebDriver(new
						URL("http://localhost:5588/wd/hub"), caps);
			}
			if (browser.equalsIgnoreCase("Chrome")) {
				caps = DesiredCapabilities.chrome();
				driver = new RemoteWebDriver(new
						URL("http://localhost:5566/wd/hub"), caps);
			}
			if (browser.equalsIgnoreCase("Firefox")) {
				caps= DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(new
						URL("http://localhost:5577/wd/hub"), caps);
			}
			if(browser.equalsIgnoreCase("HeadlessMode")) {
				caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"C:\\Users\\thaoc\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
				driver = new PhantomJSDriver(caps);
			}
			setWebDriver(driver);
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		 @Test
		    public void test() {
		        String url = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
		        getDriver().manage().window().maximize();
		        getDriver().get(url);
		        WebElement input = getDriver().findElement(By.xpath("//input[@id='user-message']"));
				String expectValue="Automation Tester";
				input.sendKeys(expectValue);
				WebElement message = getDriver().findElement(By.xpath("//button[@onclick='showInput();']"));
				message.click();
				WebElement verifyMessage = getDriver().findElement(By.xpath("//div[@id='user-message']"));
				String actualValue = verifyMessage.getText();
				System.out.println(actualValue);
				assertEquals(actualValue,"Your Message: "+expectValue);

		    }
		

		public WebDriver getDriver() {
			return dr.get();
		}

		public void setWebDriver(RemoteWebDriver driver) {
			dr.set(driver);
		}

		@AfterClass
		public void afterClass() {
			getDriver().quit();
			dr.set(null);
		}

}
