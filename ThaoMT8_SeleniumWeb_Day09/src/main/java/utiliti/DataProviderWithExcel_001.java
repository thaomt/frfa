package utiliti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel_001 {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com.vn/?hl=vi");
	}
	@Test(dataProvider = "testData")
    public void testMethod(String author, String searchKey)
            throws InterruptedException {
        {
            WebElement searchText = driver.findElement(By.name("q"));
            // search value in google search box
            searchText.sendKeys(searchKey);
            System.out.println("Welcome ->" + author + " Your search key is->"
                    + searchKey);
            Thread.sleep(3000);
            String testValue = searchText.getAttribute("value");
            System.out.println(testValue + "::::" + searchKey);
            searchText.clear();
            // Verify if the value in google search box is correct
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        }
    }
    @DataProvider(name = "testData")
    public Object[][] getDataFromExcel() throws Exception {
        Object[][] testObjArray = Excel.getTableArray(System.getProperty("user.dir") + "\\src\\main\\java\\utiliti\\TestData.xlsx","Sheet1");
        return (testObjArray);
    }
	@AfterMethod

	public void afterMethod() {

		driver.close();

	}

}
