package Final.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Final.page.LoginPage;
public class testWithTable {
	WebDriver driver;
	String link = "http://demo.whatacart.com/backend/index.php/catalog/products/attribute/manage";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(link);
	}

	@Test
	public void test() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
		Thread.sleep(2000);
		By table = By.xpath("//*[@id='grid-view']/div/div[2]/div[1]/table/tbody");
		List<WebElement> rows = driver.findElement(table).findElements(By.tagName("tr"));
		// print the first row value of table
		System.out.println(rows.size());
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
//			for (WebElement col : cols) {
//				System.out.print(col.getText() + "\t");
//			}
//			System.out.println();
			if (cols.get(1).getText().equals("test") && cols.get(2).getText().equals("Memory")) {
				System.out.println(cols.get(1).getText());
			}
			
		}

	}

}
