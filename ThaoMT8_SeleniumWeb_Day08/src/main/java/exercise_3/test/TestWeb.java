package exercise_3.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import exercise_3.page.Cookiess;
import exercise_3.page.HomePage;
import exercise_3.page.TopsPage;
import exercise_3.page.WomenPage;

public class TestWeb {
	WebDriver driver;
	TopsPage topsPage;
	WomenPage womenPage;
	Cookiess cookiess;
	HomePage homePage;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=authentication");
		topsPage=new TopsPage(driver);
		womenPage=new WomenPage(driver);
		cookiess=new Cookiess(driver);
		homePage=new HomePage(driver);
	}
	/*verify display
	    String javascript = "document.querySelector('#block_top_menu a[title=Tops]')";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = (WebElement) jsExecutor.executeScript(javascript);
        element.isDisplayed();
	 */
	@Test
	public void test(){
		homePage.clickWomen();
		womenPage.checkDisplay();
		womenPage.clickTops();
		topsPage.movesBack();
		topsPage.moveForward();
		topsPage.clickT_Shirts();	
		cookiess.getAllCookies();
		
	}
	@After
	public void tearDown() {
		if(null!=driver) {
			driver.close();
			driver.quit();
		}
	}
}
