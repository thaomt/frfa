package exercise_5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {
	WebDriver chromeDriver;
	String link = "https://www.seleniumeasy.com/test/table-pagination-demo.html";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		chromeDriver.get(link);
	}

	@Test
	public void test() {
		WebElement title = chromeDriver.findElement(By.className("btn-primary"));
		List<WebElement> nameTitle = title.findElements(By.tagName("tr"));
		for (WebElement name : nameTitle) {
			List<WebElement> colnames = name.findElements(By.tagName("th"));
			for (WebElement colnamess : colnames) {
				System.out.print(colnamess.getText() + "\t");
			}
		}
		System.out.println();
		WebElement table = chromeDriver.findElement(By.id("myTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		//print the first row value of table
		List<WebElement> cols = rows.get(0).findElements(By.tagName("td"));
		for (WebElement col : cols) {
			System.out.print(col.getText() + "\t");
		}
	}
	@After
	public void tearDown() {
		chromeDriver.quit();
	}

}
